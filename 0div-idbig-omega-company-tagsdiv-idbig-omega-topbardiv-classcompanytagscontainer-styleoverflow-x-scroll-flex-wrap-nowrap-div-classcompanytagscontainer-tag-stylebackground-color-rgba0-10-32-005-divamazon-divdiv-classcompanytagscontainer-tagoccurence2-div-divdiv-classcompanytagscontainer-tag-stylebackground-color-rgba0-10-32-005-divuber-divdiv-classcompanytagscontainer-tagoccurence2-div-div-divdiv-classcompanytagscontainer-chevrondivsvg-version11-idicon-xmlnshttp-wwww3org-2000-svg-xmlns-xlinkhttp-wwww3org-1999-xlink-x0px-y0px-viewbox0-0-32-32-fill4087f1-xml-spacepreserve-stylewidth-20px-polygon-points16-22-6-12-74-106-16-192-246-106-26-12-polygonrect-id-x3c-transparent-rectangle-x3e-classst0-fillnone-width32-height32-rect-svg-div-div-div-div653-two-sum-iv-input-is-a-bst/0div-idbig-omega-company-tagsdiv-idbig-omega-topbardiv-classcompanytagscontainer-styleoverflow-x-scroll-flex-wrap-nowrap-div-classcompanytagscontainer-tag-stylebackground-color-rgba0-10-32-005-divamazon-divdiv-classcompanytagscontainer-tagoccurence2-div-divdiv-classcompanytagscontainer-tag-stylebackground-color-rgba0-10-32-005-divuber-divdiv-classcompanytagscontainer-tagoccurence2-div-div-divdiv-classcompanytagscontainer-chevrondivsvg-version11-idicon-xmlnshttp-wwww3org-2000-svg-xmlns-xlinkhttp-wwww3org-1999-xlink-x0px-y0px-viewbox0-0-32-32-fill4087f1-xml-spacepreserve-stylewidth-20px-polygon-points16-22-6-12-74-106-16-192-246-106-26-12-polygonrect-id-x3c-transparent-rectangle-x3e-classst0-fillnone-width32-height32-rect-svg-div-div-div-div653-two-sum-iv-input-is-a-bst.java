/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private TreeNode findSuccessor(TreeNode root, TreeNode node) {
        TreeNode successor = null;
        TreeNode curr = root;
        
        while(curr != null) {
            
            if(curr.val > node.val) {
                successor = curr;
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        
        return successor;
            
    }
    
    private TreeNode findPredecessor(TreeNode root, TreeNode node) {
        TreeNode predecessor = null;
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.val < node.val) {
                predecessor = curr;
                curr = curr.right;
            }
            else 
                curr = curr.left;
        }
        return predecessor;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        TreeNode start = root;
        TreeNode end = root;
        

        while(start.left != null){
            start = start.left;
        }
        
        while(end.right != null){
            end = end.right;
        }
        
        while(start != end) {
            
            int sum = start.val + end.val;
            
            if(sum == k) return true;
            
            else if(sum < k) {
                start = findSuccessor(root, start);
            }
            else {
                end = findPredecessor(root, end);
            }
            
        }
        
        return false;
        
    }
}