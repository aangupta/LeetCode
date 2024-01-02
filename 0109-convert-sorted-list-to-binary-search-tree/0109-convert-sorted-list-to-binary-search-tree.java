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
    
    private TreeNode sortedListToBSTUtils (int[] arr, int start, int end) {
        if(start > end) return null;
        
        if(start == end) {
            return new TreeNode(arr[start]);
        }
        
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = sortedListToBSTUtils(arr, start, mid - 1);
        root.right = sortedListToBSTUtils(arr, mid + 1, end);
        
        return root;
    }
    private int findLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head == null) return null;
        
        int count = findLength(head);
        int[] arr = new int[count];
        
        ListNode curr = head;
        int i = 0;
        while(curr != null) {
            arr[i] = curr.val;
            i++;
            curr = curr.next;
        }
        
        return sortedListToBSTUtils(arr, 0, count-1);
    }
}