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
    private void leafSimilarUtils(TreeNode root, List<Integer> res) { 
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
            res.add(root.val);
        
        leafSimilarUtils(root.left, res);
        leafSimilarUtils(root.right, res);
        
        
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSeq1 = new ArrayList<>();
        List<Integer> leafSeq2 = new ArrayList<>();
        
        leafSimilarUtils(root1,leafSeq1);
        leafSimilarUtils(root2, leafSeq2);
        
        int n = leafSeq1.size();
        
        if(leafSeq1.size() != leafSeq2.size())
            return false;
        
        for(int i = 0; i < n; i++) {
            if(leafSeq1.get(i) != leafSeq2.get(i))
                return false;
        }
        
        return true;
    }
}