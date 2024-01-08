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
    
    private int rangeSumBSTUtils(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        int leftSum = 0, rightSum = 0;
        
        leftSum = rangeSumBSTUtils(root.left, low, high);
        rightSum += rangeSumBSTUtils(root.right, low, high);
        
        return (root.val >= low && root.val <= high ? root.val + leftSum + rightSum : leftSum + rightSum);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTUtils(root, low, high);
        
    }
}