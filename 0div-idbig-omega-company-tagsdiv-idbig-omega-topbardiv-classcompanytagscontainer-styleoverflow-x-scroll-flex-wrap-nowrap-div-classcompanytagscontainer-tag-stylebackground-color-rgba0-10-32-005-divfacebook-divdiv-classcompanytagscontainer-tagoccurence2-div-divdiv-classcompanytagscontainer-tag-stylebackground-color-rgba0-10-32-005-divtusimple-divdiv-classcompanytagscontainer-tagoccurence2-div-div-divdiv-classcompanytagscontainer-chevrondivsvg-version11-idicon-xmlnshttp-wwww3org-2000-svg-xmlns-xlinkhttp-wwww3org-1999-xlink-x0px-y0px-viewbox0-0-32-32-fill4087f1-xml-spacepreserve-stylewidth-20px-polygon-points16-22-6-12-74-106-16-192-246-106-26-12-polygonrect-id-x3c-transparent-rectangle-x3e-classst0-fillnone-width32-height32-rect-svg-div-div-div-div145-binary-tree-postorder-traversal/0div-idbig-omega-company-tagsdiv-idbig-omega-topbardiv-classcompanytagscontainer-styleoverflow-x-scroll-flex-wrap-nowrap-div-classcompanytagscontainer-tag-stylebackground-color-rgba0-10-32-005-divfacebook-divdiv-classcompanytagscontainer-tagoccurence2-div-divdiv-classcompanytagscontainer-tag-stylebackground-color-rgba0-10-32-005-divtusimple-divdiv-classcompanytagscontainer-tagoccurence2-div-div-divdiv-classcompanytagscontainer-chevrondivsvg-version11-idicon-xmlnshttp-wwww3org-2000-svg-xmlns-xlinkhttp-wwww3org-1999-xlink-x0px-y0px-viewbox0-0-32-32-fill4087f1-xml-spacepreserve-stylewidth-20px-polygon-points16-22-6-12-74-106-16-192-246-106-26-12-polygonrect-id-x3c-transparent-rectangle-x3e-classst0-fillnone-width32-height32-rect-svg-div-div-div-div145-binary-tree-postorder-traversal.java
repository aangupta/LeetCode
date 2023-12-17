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
    private void postorderTraversalUtils(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        postorderTraversalUtils(root.left, result);
        postorderTraversalUtils(root.right, result);
        result.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        postorderTraversalUtils(root, result);
        return result;
    }
}