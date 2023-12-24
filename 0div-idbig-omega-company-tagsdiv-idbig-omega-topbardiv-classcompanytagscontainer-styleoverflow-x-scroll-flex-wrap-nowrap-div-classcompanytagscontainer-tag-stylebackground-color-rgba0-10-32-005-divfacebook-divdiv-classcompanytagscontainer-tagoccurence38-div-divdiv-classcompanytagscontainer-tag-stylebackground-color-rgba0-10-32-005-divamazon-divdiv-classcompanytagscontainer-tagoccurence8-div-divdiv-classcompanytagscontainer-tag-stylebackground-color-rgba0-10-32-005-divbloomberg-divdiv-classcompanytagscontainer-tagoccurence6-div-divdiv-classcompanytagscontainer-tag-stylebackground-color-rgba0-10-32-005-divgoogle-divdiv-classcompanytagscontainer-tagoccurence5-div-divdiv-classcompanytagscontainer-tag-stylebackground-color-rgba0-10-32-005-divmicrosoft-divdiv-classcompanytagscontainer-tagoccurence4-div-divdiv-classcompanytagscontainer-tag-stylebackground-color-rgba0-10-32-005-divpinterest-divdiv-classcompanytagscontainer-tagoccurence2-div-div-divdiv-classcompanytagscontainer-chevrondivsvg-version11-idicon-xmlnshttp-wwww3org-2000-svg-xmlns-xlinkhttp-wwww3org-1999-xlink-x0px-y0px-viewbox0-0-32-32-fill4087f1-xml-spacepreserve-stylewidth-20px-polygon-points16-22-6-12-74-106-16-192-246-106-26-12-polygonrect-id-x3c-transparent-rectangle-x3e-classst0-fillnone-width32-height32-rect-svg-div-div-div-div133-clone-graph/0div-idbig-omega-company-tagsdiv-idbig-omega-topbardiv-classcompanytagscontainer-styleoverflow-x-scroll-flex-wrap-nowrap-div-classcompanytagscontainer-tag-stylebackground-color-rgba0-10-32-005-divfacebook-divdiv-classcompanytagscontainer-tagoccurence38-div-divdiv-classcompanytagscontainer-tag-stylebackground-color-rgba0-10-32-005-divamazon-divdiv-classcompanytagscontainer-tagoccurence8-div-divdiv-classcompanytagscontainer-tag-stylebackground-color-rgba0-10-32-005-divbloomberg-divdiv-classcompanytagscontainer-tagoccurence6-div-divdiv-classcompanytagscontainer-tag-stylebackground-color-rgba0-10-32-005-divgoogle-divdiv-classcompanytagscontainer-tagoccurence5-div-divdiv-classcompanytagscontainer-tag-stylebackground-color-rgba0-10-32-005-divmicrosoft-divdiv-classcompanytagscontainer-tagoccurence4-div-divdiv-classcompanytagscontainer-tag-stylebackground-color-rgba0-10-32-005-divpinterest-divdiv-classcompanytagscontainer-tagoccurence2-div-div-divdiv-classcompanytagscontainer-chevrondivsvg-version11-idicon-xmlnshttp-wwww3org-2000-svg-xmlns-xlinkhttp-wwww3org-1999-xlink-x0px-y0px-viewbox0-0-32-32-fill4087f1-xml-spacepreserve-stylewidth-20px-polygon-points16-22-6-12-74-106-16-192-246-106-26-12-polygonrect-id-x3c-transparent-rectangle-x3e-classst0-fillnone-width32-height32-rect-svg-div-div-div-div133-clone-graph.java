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
        
        if(map.containsKey(node) == true)
            return map.get(node);
        
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        
        for(Node neighbor : node.neighbors) {
            map.get(node).neighbors.add(cloneGraphUtils(neighbor, map));
        }
        
        return copyNode;
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        
        return cloneGraphUtils(node, map);
    }
}