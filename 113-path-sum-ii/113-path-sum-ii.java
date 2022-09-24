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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        pathSumRecursive(root, targetSum, currentPath, allPaths);
        
        return allPaths;
    }
    
    private void pathSumRecursive(TreeNode currentNode, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths ){
        
        if(currentNode == null)
            return;
        
        // add the current node to the path
        currentPath.add(currentNode.val);
        
        // if the current node is a leaf and its value is equal to sum, save the current path
        if(currentNode.val == targetSum && currentNode.left == null && currentNode.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }
        else {
            // traverse the left sub-tree
            pathSumRecursive(currentNode.left, targetSum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            pathSumRecursive(currentNode.right, targetSum - currentNode.val, currentPath, allPaths);    
        }
        
        // remove the current node from the path to backtrack, 
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
        
    }
    
    //TC O(n2) - O(n) for traversing the nodes * O(n) for storing the root to leaf path 
}