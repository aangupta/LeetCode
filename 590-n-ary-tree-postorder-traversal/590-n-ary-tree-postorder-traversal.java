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
    public List<Integer> postorder(Node root) {
        List<Integer> postOrderList = new ArrayList<>();
        
        postOrder(root,  postOrderList);
        
        return  postOrderList;
        
    }
    
    private void  postOrder(Node root, List<Integer> postOrderList){
        
        if(root == null)
            return;
        
        for(Node child : root.children)
            postOrder(child,postOrderList);
        
        postOrderList.add(root.val);
    }
}




