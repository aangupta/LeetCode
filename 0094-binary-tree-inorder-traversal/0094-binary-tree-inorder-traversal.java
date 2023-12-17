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
    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(root != null || stack.size() > 0){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        
        return result;
        
    }
}