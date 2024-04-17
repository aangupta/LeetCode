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
    String result = "";
    
    private void smallestFromLeafUtils(TreeNode root, String curr) {
        if(root == null)
            return;
        
        curr = (char) (root.val + 'a') + curr; //this will take O(length of curr) which is worst case O(n)
        
        //System.out.println(curr);

        
        if(root.left == null && root.right == null) {
            if(result.equals("") || result.compareTo(curr) > 0){
                result = curr;
               // System.out.println(result);
            }
            return;
            
        }
        smallestFromLeafUtils(root.left, curr);
        smallestFromLeafUtils(root.right, curr);
    }
    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeafUtils(root, "");
        return result;
    }
}

//TC O(n *. n)
//SC O(n) recusive stack space