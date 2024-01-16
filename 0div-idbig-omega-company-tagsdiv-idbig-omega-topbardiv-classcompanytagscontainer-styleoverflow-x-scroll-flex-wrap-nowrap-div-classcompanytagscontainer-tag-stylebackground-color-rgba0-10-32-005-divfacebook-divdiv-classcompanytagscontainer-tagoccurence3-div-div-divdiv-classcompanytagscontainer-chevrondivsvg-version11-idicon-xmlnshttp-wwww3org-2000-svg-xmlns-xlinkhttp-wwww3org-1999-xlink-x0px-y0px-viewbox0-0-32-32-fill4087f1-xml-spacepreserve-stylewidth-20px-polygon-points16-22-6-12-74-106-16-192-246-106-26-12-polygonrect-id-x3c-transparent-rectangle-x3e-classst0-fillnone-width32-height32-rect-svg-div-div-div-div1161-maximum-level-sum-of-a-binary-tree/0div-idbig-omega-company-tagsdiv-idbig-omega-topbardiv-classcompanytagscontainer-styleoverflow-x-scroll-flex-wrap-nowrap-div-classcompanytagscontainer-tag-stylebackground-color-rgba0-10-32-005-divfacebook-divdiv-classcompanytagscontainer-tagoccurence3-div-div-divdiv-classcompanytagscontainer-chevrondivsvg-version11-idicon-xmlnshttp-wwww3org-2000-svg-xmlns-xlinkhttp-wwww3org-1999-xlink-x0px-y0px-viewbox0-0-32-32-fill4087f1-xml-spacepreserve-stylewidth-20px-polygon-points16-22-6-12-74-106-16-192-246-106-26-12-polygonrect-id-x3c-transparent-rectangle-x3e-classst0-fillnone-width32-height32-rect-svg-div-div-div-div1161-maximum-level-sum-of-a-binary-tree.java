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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 1;
        
        while(queue.size() > 0) {
            int currLevelSum = 0;
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                queue.remove();
                
                currLevelSum += node.val;
                
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);
            }
            
            if(currLevelSum > maxSum) {
                maxSum = currLevelSum;
                level = currLevel;
            }
            currLevel++;
        }
        
        return level;
        
    }
}