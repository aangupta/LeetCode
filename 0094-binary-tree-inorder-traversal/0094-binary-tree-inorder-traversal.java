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
    //Recursive
    
    private void  inorderTraversalUtils(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        
        inorderTraversalUtils(root.left, result);
        result.add(root.val);
        inorderTraversalUtils(root.right, result);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        inorderTraversalUtils(root, result);
        
        return result;
        
        
    }
}