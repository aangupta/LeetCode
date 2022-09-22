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
    public TreeNode increasingBST(TreeNode root) {
        
        TreeNode newRoot = null;
        TreeNode newCurr = null;
        
        if(root == null)
            return root;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        
        while(curr != null ||  stack.size() > 0){
            
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            if(newRoot == null){
                newRoot = new TreeNode(curr.val);
                newCurr = newRoot;
            } else {
                newCurr.right = new TreeNode(curr.val);
                newCurr = newCurr.right;
            }
            
            curr = curr.right;
        }
        
        //root = newRoot;
        
        return newRoot;
        
    }
}