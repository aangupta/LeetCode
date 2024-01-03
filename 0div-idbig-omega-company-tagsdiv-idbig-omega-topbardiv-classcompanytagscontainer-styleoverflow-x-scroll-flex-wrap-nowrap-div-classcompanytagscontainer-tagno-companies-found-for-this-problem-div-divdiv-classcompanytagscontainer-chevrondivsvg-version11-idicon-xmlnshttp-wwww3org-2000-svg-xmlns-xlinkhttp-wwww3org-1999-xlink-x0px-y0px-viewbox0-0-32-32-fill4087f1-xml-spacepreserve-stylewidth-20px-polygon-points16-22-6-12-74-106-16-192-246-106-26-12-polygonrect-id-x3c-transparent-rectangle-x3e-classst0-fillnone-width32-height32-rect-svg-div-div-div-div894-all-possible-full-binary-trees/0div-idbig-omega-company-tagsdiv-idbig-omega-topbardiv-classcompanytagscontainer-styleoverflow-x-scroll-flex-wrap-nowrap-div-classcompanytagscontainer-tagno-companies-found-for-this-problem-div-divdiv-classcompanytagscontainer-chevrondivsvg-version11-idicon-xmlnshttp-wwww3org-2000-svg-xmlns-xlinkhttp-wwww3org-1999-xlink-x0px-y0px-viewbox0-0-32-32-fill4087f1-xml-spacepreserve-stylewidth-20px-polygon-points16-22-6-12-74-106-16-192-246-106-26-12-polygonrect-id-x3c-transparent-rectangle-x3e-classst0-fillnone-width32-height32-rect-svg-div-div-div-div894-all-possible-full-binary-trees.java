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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> res = new ArrayList<>();
        
        if(n % 2 == 0) {
            return new ArrayList<>();
        }
        
        if(n == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        
        //out of n nodes , 1 node is for root
        //remaining n-1 nodes we have to arrange in left and right subtree
        
        for(int l = 1; l <= n-1; l++) {
            int r = n - 1 - l;
             List<TreeNode> lNodes = allPossibleFBT(l);
             List<TreeNode> rNodes = allPossibleFBT(r);
            
             for(TreeNode lNode : lNodes) {
                 for(TreeNode rNode : rNodes) {
                     TreeNode root = new TreeNode(0);
                     root.left = lNode;
                     root.right = rNode;
                     res.add(root);
                 }
             }
            
        }
        return res;
    }
}