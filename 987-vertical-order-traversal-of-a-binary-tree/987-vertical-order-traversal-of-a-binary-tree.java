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
class Tuple {
    TreeNode node;
    int row;
    int col;
    
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer> > > map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        
        queue .add(new Tuple(root, 0, 0));
        
        while(queue.size() > 0){
            
            Tuple tuple = queue.poll();
            TreeNode currentNode = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            
            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            
            map.get(x).get(y).add(currentNode.val);
            
            if(currentNode.left != null){
                queue.add(new Tuple(currentNode.left, x - 1, y + 1));
            }
            
               
            if(currentNode.right != null){
                queue.add(new Tuple(currentNode.right, x + 1, y + 1));
            }
            
        }
        
         List<List<Integer>> result = new ArrayList<>();
        
         for(TreeMap < Integer, PriorityQueue < Integer >> ys : map.values()){
             result.add(new ArrayList<>());
             
             for(PriorityQueue<Integer> nodes: ys.values()){
                 while(nodes.size() > 0){
                   result.get(result.size() - 1).add(nodes.poll());
                 }
             }
         }
        
        return result;
        
    }
    // TC : O(N*logN*logN*logN)
    //SC : O(N)


}