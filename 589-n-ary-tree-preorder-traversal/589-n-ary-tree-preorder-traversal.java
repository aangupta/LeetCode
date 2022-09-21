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
    public List<Integer> preorder(Node root) {
        List<Integer> preOrderList = new ArrayList<>();
        
        preorder(root, preOrderList);
        
        return preOrderList ;
    }
    
    private void preorder(Node root, List<Integer> preOrderList){
        //base case
        if(root == null)
            return;
        //adding the root value to the list
        preOrderList.add(root.val);
        
        //traversing through the current node children
        for(Node child : root.children) {
            preorder(child, preOrderList);
        }
    }
}