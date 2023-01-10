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
    private TreeNode mergeTreesUtils(TreeNode root1, TreeNode root2) {
        
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        
        root1.val += root2.val;
        root1.left = mergeTreesUtils(root1.left, root2.left);
        root1.right = mergeTreesUtils(root1.right, root2.right);
        return root1;
        
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesUtils(root1, root2);
        
    }
}