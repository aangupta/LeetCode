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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
        
        stack1.push(root);
        
        while(stack1.size() > 0){
            root = stack1.pop();
            stack2.push(root);
            
            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
            
        }
        
        while(stack2.size() > 0){
            result.add(stack2.pop().val);
        }
        
        return result;
        
    }
}