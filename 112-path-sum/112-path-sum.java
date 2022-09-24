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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if(root.val == targetSum && root.left == null && root.right == null)
            return true;
        
        
        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val));
        
    }
    
    //TC O(n) Sc O(n) in worst case;
}