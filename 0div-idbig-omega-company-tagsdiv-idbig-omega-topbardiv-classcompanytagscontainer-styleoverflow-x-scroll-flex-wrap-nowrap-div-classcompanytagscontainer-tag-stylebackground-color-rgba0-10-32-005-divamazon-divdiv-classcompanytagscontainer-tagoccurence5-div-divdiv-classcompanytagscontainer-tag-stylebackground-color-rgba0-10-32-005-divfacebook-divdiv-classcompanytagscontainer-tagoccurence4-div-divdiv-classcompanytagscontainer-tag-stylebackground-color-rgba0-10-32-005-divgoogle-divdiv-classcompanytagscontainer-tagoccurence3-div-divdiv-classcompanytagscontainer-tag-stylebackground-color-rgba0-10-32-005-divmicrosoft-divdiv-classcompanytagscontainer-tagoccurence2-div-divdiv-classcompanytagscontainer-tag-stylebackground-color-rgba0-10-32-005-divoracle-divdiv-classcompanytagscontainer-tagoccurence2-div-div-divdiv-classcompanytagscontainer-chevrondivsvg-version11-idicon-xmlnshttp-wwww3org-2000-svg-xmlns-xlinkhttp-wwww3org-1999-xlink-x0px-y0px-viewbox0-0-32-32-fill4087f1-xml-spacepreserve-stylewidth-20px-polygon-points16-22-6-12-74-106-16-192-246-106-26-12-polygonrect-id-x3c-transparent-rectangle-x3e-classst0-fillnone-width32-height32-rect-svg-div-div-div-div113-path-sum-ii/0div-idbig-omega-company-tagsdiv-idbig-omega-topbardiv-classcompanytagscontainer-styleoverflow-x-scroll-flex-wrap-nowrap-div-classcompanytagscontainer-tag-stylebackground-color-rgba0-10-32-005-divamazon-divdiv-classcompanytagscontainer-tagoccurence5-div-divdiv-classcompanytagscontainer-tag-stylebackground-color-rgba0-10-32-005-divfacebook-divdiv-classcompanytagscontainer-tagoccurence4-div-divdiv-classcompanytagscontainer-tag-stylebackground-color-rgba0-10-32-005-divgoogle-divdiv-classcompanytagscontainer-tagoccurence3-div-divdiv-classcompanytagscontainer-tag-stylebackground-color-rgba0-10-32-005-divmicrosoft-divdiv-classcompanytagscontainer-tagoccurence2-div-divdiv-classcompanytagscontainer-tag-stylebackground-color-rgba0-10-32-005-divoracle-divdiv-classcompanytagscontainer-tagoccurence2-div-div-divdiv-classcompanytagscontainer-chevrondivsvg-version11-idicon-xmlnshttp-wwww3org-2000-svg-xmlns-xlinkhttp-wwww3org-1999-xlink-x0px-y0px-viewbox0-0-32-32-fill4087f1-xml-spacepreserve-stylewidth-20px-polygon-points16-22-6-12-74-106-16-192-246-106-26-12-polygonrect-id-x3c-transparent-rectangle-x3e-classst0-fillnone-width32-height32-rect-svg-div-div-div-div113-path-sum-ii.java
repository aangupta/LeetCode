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
    
    private void pathSumUtils(TreeNode currNode, int targetSum,List<Integer> currPath,  List<List<Integer>> allPaths) {
        if(currNode == null) return;
        
        //add the currnode val to the curr path
        currPath.add(currNode.val);
        
       // if the current node is a leaf and its value is equal to sum, save the current path
        if(currNode.left == null && currNode.right == null && currNode.val == targetSum)
            allPaths.add(new ArrayList<>(currPath));
        
        //traverse left subtree
        pathSumUtils(currNode.left, targetSum  - currNode.val, currPath, allPaths);
        
        //traverse right subtree
        pathSumUtils(currNode.right, targetSum - currNode.val, currPath, allPaths);
        
        // remove the current node from the path to backtrack, 
        currPath.remove(currPath.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        
        if(root == null) return allPaths;
        
        pathSumUtils(root, targetSum, currPath, allPaths);
        
        return allPaths;
        
    }
}