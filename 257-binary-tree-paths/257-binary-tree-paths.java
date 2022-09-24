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
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> allPaths = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();
        
        binaryTreePaths(root, currentPath, allPaths);
        
        return allPaths;
        
    }
    
    private void binaryTreePaths(TreeNode currentNode, StringBuilder currentPath, List<String> allPaths){
        
        if(currentNode == null){
            return;
        }
        
        int length = currentPath.length();
        currentPath.append(currentNode.val);
        
        // if the current node is a leaf, save the current path
        if(currentNode.left == null && currentNode.right == null){
            allPaths.add(currentPath.toString());
        }
        else {
            currentPath.append("->");
            // traverse the left sub-tree
            binaryTreePaths(currentNode.left, currentPath, allPaths);
            // traverse the right sub-tree
            binaryTreePaths(currentNode.right, currentPath, allPaths);
            
        }
        
        /* When using StringBuilder, We can just keep track of the length of the StringBuilder before we append anything to it before recursion and afterwards set the length back. Another trick is when to append the "->", since we don't need the last arrow at the end of the string, we only append it before recurse to the next level of the tree.*/
        currentPath.setLength(length);
    }
}