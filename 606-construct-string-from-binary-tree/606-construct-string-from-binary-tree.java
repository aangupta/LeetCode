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
    public String tree2str(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        tree2strUtils(root, sb);
        return (sb.toString());    
    }
    
    private void tree2strUtils(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        
        //base case
        if(root.left == null && root.right == null){
            return;
        }
        
        if(root.left != null){
            sb.append("(");
            tree2strUtils(root.left, sb);
            sb.append(")");
        }
        
        if(root.right != null){
            if(root.left == null){
                sb.append("()");
            }
            
            sb.append("(");
            tree2strUtils(root.right, sb);
            sb.append(")");
        }
    }
}