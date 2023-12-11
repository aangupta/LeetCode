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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
       
        
        while(queue.size() > 0 ){
            int size = queue.size();
           
            ArrayList<Integer> temp = new ArrayList<Integer>(size);
            
            for(int i= 0; i < size; i++) {
                TreeNode currNode = queue.peek();
                queue.poll();
                
                temp.add(currNode.val);
                
                if(currNode.left != null)
                    queue.offer(currNode.left);
                
                if(currNode.right!= null)
                    queue.offer(currNode.right);
            }
            
            if(result.size() % 2 == 1) Collections.reverse(temp);
            result.add(temp);
            
        }
        
        return result;
    }
}