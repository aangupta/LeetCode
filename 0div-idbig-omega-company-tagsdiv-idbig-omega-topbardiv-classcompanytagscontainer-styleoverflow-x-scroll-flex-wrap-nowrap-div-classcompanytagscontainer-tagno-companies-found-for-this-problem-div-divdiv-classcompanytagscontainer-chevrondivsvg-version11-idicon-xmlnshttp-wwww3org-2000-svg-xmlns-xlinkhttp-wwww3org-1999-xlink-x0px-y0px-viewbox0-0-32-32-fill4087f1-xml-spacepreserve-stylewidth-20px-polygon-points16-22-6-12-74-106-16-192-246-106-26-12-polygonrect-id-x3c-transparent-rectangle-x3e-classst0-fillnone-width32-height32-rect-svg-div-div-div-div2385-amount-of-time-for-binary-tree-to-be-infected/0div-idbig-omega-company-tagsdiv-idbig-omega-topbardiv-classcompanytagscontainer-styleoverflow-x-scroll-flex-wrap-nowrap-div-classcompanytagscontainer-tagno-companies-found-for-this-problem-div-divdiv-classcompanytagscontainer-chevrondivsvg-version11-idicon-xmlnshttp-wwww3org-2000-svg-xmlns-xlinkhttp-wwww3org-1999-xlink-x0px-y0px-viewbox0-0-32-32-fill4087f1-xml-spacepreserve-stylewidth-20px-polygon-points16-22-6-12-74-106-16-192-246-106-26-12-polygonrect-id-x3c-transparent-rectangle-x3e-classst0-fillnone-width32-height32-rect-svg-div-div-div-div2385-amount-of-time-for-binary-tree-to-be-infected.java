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
    TreeNode startNode = null;
    private void markParent(TreeNode root,  Map<TreeNode, TreeNode> parentTrack, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (queue.size() > 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.peek();
                queue.remove();
                if(curr.val == start)
                    startNode = curr;
                
                if(curr.left != null) {
                    parentTrack.put(curr.left, curr);
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    parentTrack.put(curr.right, curr);
                    queue.add(curr.right);
                }
            }
         }
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        
        
        markParent(root, parentTrack,start);
        //System.out.println(startNode.val);
        
        Map<TreeNode, Boolean> visited = new HashMap<>();
        
        int time = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        visited.put(startNode, true);
        
        while (queue.size() > 0) {
            int size = queue.size();
            time++;
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.peek();
                queue.remove();
                
                
                if(curr.left != null && visited.get(curr.left) == null ) {
                    visited.put(curr.left, true);
                    queue.add(curr.left);
                }
                
                if(curr.right != null && visited.get(curr.right) == null) {
                    visited.put(curr.right, true);
                    queue.add(curr.right);
                }
                
                TreeNode parent = parentTrack.get(curr);
                if(parent != null && visited.get(parent) == null) {
                    visited.put(parent, true);
                    queue.add(parent);
                }
            }
         }
        return time;
        
        
        
    }
}