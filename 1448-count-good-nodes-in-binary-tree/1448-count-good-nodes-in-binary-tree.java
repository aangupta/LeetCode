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
    
    private int goodNodes(TreeNode root, int max){
        if(root == null)
            return 0;
        
        max = Math.max(root.val, max);
        int left = goodNodes(root.left, max);
        int right = goodNodes(root.right, max);
        
        int curr = (root.val >= max) ? 1 : 0;
        return curr + left + right;
    }
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
        
    }
}