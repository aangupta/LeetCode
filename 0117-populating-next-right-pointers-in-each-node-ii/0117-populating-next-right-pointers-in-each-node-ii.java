/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(queue.size() > 0){
            int count = queue.size();
            ArrayList<Node> currLevel = new ArrayList<>();
            
            for(int i = 0; i < count; i++){
                Node node = queue.poll();
                currLevel.add(node);
                
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);
            }
            
            Node next = currLevel.get(currLevel.size() - 1);
            int i = currLevel.size() - 2;
            
            while(i >=0 ) {
                Node curr = currLevel.get(i);
                curr.next = next;
                next = curr;
                i--;
            }
        }
        
        return root;
        
    }
}