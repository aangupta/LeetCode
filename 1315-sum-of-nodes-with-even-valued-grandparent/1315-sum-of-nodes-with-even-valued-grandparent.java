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
    private int sumEvenGrandparent(TreeNode current, TreeNode parent, TreeNode grandParent){
        if(current == null)
            return 0;
        
        int currSum = (grandParent != null && grandParent.val %2 == 0) ? current.val : 0;
        
        int leftSum = sumEvenGrandparent(current.left, current, parent);
        int rightSum = sumEvenGrandparent(current.right, current, parent);
        
        return currSum + leftSum + rightSum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, null, null);
        
    }
}