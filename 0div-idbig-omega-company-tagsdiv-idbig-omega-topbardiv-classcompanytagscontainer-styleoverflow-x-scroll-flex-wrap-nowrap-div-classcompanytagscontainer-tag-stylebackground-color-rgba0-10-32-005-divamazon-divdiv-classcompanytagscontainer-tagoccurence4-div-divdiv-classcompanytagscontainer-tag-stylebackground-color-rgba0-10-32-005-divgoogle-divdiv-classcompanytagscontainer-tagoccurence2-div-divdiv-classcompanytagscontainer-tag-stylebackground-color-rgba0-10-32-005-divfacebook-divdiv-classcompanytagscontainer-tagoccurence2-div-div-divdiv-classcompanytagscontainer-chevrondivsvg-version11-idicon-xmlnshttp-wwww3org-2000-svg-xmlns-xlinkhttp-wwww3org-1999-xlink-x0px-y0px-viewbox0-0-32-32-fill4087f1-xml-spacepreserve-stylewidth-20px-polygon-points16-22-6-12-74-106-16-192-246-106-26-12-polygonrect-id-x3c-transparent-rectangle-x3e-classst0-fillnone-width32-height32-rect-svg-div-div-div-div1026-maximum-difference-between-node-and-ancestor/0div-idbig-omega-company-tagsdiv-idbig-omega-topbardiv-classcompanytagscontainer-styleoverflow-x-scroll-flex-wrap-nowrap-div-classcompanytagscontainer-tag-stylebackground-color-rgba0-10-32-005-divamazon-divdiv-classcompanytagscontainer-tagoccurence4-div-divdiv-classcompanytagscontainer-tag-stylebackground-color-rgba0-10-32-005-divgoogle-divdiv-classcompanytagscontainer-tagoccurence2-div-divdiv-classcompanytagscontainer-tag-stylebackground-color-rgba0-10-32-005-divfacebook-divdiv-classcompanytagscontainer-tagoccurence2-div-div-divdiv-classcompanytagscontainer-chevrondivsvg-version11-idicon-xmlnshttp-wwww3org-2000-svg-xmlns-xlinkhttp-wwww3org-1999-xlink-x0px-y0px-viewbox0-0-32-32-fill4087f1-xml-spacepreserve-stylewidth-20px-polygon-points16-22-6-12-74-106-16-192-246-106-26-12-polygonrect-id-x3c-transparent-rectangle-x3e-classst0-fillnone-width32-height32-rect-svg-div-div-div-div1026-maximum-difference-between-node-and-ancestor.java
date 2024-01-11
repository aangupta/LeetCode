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
    int diff = 0;
    private int[]  maxAncestorDiffUtils (TreeNode root) {
        if(root == null) {
            return new int[]{(int)1e9, (int)-1e9};
        }
        
        int[] left =  maxAncestorDiffUtils(root.left);
        int[] right =  maxAncestorDiffUtils(root.right);
        
        int min = Math.min(root.val, Math.min(left[0], right[0]));
        int max = Math.max(root.val, Math.max(left[1], right[1]));
        
        diff = Math.max(diff, Math.max(Math.abs(root.val - min), Math.abs(root.val - max)));
        
        return new int[] {min, max};
    }
    public int maxAncestorDiff(TreeNode root) {
        maxAncestorDiffUtils(root);
        return diff;
    }
}