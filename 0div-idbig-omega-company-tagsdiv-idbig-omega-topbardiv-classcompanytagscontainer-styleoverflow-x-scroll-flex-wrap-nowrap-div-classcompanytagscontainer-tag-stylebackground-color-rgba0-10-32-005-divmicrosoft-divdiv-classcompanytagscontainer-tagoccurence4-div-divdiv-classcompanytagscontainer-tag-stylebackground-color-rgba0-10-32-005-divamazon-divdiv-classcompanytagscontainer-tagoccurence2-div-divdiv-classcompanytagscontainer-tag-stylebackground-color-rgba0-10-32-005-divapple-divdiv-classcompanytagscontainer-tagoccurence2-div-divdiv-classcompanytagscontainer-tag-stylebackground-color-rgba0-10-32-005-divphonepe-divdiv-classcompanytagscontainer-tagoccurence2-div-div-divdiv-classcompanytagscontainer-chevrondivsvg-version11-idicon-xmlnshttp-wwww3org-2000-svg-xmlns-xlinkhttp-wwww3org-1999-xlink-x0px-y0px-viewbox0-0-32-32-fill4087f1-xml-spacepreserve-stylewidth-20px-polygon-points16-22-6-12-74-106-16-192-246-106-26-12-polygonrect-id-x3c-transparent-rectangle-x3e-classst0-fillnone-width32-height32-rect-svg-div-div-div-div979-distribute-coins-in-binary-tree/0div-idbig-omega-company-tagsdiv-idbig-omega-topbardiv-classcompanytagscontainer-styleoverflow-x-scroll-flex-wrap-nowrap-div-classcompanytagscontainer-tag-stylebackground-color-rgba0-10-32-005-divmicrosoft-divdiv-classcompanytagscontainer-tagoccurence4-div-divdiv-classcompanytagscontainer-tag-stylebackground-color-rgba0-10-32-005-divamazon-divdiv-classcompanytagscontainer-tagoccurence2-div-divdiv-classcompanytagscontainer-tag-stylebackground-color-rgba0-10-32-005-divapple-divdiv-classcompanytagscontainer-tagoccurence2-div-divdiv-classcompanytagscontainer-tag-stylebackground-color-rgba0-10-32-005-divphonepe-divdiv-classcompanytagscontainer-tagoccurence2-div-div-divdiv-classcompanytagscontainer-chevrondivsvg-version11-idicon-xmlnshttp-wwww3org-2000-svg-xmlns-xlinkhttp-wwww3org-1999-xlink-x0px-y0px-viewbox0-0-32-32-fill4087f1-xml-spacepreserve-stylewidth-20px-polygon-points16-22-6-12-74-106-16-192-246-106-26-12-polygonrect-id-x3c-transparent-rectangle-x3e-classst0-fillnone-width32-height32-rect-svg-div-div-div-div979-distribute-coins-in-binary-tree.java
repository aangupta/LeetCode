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
    int moves = 0;
    
    private int distributeCoinsUtils(TreeNode root) {
        if(root == null)
            return 0;
        
        int extraCandiesFromLeftSubtree = distributeCoinsUtils(root.left);
        int extraCandiesFromRightSubtree = distributeCoinsUtils(root.right);
        
        int totalExtraCandies = (root.val + extraCandiesFromLeftSubtree + extraCandiesFromRightSubtree) -1 ;
        
        moves += Math.abs(extraCandiesFromLeftSubtree) + Math.abs(extraCandiesFromRightSubtree);
        
        return totalExtraCandies;
        
    }
    public int distributeCoins(TreeNode root) {
        distributeCoinsUtils(root);
        return moves;
    }
}