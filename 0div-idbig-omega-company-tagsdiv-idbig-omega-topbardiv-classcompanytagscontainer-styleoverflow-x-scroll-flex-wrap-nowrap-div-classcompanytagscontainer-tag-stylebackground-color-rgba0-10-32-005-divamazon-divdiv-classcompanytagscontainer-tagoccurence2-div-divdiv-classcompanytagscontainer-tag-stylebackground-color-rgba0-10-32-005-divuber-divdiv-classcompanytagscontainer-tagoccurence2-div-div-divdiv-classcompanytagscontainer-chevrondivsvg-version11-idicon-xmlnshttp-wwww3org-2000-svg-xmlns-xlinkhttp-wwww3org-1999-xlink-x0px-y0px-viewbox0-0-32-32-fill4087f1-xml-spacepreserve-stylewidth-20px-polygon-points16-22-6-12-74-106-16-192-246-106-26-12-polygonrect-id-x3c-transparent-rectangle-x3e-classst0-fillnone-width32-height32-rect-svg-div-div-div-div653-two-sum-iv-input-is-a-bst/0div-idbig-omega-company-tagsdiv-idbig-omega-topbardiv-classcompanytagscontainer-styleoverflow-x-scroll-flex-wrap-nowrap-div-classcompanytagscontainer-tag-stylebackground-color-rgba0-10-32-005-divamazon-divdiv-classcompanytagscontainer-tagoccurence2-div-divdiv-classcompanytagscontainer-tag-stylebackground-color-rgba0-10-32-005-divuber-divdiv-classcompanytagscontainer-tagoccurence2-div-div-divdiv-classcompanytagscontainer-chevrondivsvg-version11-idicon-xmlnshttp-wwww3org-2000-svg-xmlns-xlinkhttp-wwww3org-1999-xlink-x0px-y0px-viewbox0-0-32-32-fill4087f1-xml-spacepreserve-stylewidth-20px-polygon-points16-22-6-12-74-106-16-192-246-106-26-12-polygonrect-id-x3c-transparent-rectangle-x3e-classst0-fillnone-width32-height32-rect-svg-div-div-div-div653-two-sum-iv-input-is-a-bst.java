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
    
    /*
    * Find the inorder traversal of the BST and store it in array(sorted array)
    * Apply two sum approach to check if there exist two element whose sum equals to k
    * TC O(n)(finding the inorder traversal) + O(n)(traversing the inorder array to check there exist two element whose sum equals to k ) ~ O(n)
    * SC O(n) - inorder array
    */
    
    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        
        if(root == null) return;
        
        inorderTraversal(root.left, inorder);
        
        inorder.add(root.val);
         
        inorderTraversal(root.right, inorder);
        
        
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        
        inorderTraversal(root, inorder);
        
        int start = 0;
        int end = inorder.size() - 1;
        
        while(start < end) {
            int sum = inorder.get(start) + inorder.get(end);
            
            if(sum == k) 
                return true;
            else if(sum > k)
                end--;
            else 
                start++;
        }
        
        return false;
    }
}