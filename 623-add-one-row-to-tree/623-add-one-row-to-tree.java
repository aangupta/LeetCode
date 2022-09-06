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
    int level;
    
    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1){
             TreeNode leftSubtree = root;
             
             root = new TreeNode(val);
             root.left = leftSubtree;
             root.right = null;
            
            return root;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(root, 1));
        
        while(queue.size() > 0) {
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                Pair temp = queue.poll();
                TreeNode currentNode = temp.node;
                int currentLevel = temp.level;

                if(currentLevel == depth - 1){

                    TreeNode leftSubtree = currentNode.left;
                    TreeNode rightSubtree = currentNode.right;

                    currentNode.left = new TreeNode(val);
                    currentNode.right = new TreeNode(val);

                    currentNode.left.left = leftSubtree;
                    currentNode.right.right = rightSubtree;
                    break;
                }

                if(currentNode.left != null){
                    queue.add( new Pair(currentNode.left , currentLevel + 1));
                }

                if(currentNode.right != null){
                    queue.add( new Pair(currentNode.right , currentLevel + 1));
                }   
            }   
            
        }
        
        return root;
        
        
    }
}