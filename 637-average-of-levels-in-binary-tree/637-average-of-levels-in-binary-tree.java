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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null)
            return ans;
        
        queue.add(root);
        double sum = 0.0;
        
        while(queue.size() > 0){
            sum = 0.0;
            int size = queue.size();
            
            for(int i  = 0; i < size; i++){
                
                TreeNode curr = queue.poll();
                
                sum += curr.val;
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans.add(sum / size);
        }
        return ans;
    }
}