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
    
    private Node cloneGraphUtils(Node node,  Map<Node, Node> map) {
        if(node == null) return null;
        
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        
        for(Node neighbor : node.neighbors) {
            
            if(map.containsKey(neighbor) == false) {
                Node copyNeighbor = cloneGraphUtils(neighbor , map);
                map.get(node).neighbors.add(copyNeighbor);
            }
            else {
                Node copyNeighbor = map.get(neighbor);
                map.get(node).neighbors.add(copyNeighbor);
            }
        }
        
        return copyNode;
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        
        return cloneGraphUtils(node, map);
    }
}