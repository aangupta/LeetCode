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
    public int findBottomLeftValue(TreeNode root) {
        
        //only one node 
        if(root.left == null && root.right == null)
            return root.val;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int ans = 0;
        
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode currNode = queue.remove();
                if(i == 0)
                    ans = currNode.val;
                
                if(currNode.left != null) queue.add(currNode.left);
                if(currNode.right != null) queue.add(currNode.right);
            }
        }
        
        return ans;
        
    }
}