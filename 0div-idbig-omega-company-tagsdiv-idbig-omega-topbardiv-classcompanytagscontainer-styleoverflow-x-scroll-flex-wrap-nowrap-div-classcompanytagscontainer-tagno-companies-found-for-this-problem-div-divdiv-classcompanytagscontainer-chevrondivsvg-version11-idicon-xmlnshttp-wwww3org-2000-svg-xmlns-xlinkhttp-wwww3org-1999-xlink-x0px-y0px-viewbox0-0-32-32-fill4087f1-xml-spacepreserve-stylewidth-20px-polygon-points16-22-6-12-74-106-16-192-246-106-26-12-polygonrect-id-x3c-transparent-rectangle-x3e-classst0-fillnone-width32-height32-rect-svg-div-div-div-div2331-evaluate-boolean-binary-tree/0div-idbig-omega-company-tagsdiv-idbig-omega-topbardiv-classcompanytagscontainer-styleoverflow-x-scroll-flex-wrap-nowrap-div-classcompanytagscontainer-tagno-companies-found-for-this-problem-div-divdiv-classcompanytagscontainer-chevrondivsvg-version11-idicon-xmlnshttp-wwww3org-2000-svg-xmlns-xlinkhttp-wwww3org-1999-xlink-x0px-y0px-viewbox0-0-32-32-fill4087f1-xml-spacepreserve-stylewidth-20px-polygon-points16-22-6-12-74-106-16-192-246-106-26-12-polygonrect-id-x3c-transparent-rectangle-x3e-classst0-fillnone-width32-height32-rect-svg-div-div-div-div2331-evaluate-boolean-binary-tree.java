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
    
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null) 
            return (root.val == 1 ? true : false);
        
        
        boolean evaluateLeftTree = evaluateTree(root.left);
        boolean evaluateRightTree = evaluateTree(root.right);
        
        boolean evaluateRoot;
        
        if(root.val == 2) {
            evaluateRoot = evaluateLeftTree | evaluateRightTree;
        }
        else {
             evaluateRoot = evaluateLeftTree & evaluateRightTree;
        }
        
        return evaluateRoot;
    }
}