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
    int pathCount = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        
        if(root == null) return 0;
        
        int[] frequency = new int[10];
        
        solve(root, frequency);
        
        return pathCount;
    }
    
    private void solve(TreeNode root, int[] frequency) {
        if(root == null)
            return;
        
        frequency[root.val] += 1;
        
        if(root.left == null && root.right == null){
            int oddFrequencyCount = 0;
            
            for(int i = 0; i < frequency.length; i++){
                if(frequency[i] %2 == 1)
                    oddFrequencyCount++;
            }
            
            if(oddFrequencyCount <= 1) pathCount++;
            frequency[root.val] -=1;
            return;
        }
        
        solve(root.left, frequency);
        solve(root.right, frequency);
       
        frequency[root.val] -= 1;
        
    }
}