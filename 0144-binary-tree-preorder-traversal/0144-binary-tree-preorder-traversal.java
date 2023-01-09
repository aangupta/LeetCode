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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        
        TreeNode curr = root;
        if(curr == null)
            return preorder;
        
        Stack<TreeNode > stack = new Stack<>();
        stack.push(curr);
        
        while(stack.size() > 0) {
            curr = stack.pop();
            preorder.add(curr.val);
            
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);    
        }
        
        return preorder;
        
    }
}