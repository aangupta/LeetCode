/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        // Maps a node from original graph to the corresponding node in the cloned graph.
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        map.put(node, new Node(node.val));
        
        while(queue.size() > 0) {
            Node currNode = queue.peek();
            queue.remove();
            
            //traversing through the neighbours
            for(Node  currNeighbor : currNode.neighbors) {
                if(map.containsKey(currNeighbor) == false) {
                     map.put(currNeighbor, new Node(currNeighbor.val)); // Create a copy of currNeighbor.
                     queue.add(currNeighbor); // Add currNeighbor to the queue so that its edges will be added to the cloned graph.
                }
                
                map.get(currNode).neighbors.add(map.get(currNeighbor)); // Create the edge between currNode and the currNeighbor in the cloned graph.
            }
        }
        
       return map.get(node);
    }
}