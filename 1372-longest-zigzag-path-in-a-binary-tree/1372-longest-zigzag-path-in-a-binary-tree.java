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
    static int  longestPath = 0;
    public static int longestZigZag(TreeNode root) {
        
        if(root == null) return -1; // if root is null 
        
        longestPath = 0;
        maxZigZag(root.left, 1, false); //go right
        maxZigZag(root.right, 1, true); //go left
        
        
        return longestPath;  
    }
    
    public static void maxZigZag(TreeNode root, int step, boolean isRight){
        if(root == null) return;
        
        longestPath = Math.max(longestPath, step);
        
        if(isRight) { 
            maxZigZag(root.left, step+1, false);//if coming from right go left
            maxZigZag(root.right, 1, true); //try again from start
        } 
        else {
            maxZigZag(root.right, step+1, true);//if coming from left go right
            maxZigZag(root.left, 1, false); //try again from start
        }
    } 
}