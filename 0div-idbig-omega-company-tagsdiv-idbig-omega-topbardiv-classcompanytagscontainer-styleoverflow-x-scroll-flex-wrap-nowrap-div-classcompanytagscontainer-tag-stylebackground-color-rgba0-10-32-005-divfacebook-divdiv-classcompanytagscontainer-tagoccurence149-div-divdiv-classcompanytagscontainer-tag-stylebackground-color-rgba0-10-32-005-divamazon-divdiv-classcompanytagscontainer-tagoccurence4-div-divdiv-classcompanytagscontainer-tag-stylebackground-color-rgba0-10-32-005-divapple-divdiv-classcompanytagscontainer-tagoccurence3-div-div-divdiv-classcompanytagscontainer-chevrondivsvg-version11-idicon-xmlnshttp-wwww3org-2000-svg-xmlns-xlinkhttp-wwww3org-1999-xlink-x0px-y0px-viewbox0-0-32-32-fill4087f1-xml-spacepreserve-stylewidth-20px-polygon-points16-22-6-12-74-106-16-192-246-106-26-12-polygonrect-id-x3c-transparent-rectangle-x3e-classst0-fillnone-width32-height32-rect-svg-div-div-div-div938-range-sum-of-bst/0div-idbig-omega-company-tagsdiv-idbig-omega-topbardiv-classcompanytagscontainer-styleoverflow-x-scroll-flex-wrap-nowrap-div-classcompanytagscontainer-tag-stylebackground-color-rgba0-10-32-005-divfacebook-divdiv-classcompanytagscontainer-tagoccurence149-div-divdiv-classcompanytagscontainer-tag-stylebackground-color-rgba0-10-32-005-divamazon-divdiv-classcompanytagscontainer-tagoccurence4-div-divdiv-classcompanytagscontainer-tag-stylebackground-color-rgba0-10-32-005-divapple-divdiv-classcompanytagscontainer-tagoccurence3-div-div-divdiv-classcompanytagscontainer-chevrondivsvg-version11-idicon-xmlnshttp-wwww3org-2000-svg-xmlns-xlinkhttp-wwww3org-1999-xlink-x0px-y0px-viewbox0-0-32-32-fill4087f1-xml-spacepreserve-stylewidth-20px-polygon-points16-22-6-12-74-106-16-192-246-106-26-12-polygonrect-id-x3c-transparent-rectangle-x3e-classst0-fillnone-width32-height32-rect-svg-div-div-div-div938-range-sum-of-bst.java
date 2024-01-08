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
        
        if(root.val < low) return rangeSumBSTUtils(root.right, low, high); //excluding left subtree
        if(root.val > high) return rangeSumBSTUtils(root.left, low, high); //excluding right subtree
        
        return root.val + rangeSumBSTUtils(root.right, low, high) + rangeSumBSTUtils(root.left, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return rangeSumBSTUtils(root, low, high);
        
    }
}