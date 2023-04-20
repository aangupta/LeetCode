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
class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode _node, int _index){
        node = _node;
        index = _index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int firstIndex = 0;
            int lastIndex = 0;
            int minIndex = queue.peek().index;
            for(int i = 0; i < size; i++){
                int curr_id = queue.peek().index - minIndex;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(i == 0) firstIndex = curr_id;
                if(i== size - 1) lastIndex = curr_id;
                
                if(node.left != null)
                    queue.add(new Pair(node.left, 2*curr_id + 1));
                if(node.right != null)
                    queue.add(new Pair(node.right, 2*curr_id + 2));
            }
            width = Math.max(width, lastIndex - firstIndex + 1);
        }
        
        return width;
        
    }
}