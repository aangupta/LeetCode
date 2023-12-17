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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        if(root == null) return result;
        
        while(root != null || stack.size() > 0) {
            while(root != null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            root = root.right;
        }
        
        return result;
        
    }
}