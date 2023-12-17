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
    private void preorderTraversalUtils(TreeNode root,  List<Integer> result) {
        if(root == null)
            return;
        result.add(root.val);
        
        preorderTraversalUtils(root.left, result);
        preorderTraversalUtils(root.right, result);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        preorderTraversalUtils(root, result);
        return result;
    }
}