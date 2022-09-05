/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++){
                Node currentNode = queue.poll();
                level.add(currentNode.val);
                
                for(int j = 0; j < currentNode.children.size(); j++){
                    Node children = currentNode.children.get(j);
                    if(children != null){
                        queue.add(children);
                    }
                }
            }
            result.add(level);
        }
        
        return result;
        
    }
}