/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        
        if(head.next==null)return new TreeNode(head.val);
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        //find the middle
        //create a root element from the middle ele val
        //root.left = traverse to rest of the ele from start to mid - 1
        //root.right = traverse to rest of the ele from mid + 1 to end
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast =  fast.next.next;
        }
        
        //System.out.println(slow.val);
        //slow refers to the middle element
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}