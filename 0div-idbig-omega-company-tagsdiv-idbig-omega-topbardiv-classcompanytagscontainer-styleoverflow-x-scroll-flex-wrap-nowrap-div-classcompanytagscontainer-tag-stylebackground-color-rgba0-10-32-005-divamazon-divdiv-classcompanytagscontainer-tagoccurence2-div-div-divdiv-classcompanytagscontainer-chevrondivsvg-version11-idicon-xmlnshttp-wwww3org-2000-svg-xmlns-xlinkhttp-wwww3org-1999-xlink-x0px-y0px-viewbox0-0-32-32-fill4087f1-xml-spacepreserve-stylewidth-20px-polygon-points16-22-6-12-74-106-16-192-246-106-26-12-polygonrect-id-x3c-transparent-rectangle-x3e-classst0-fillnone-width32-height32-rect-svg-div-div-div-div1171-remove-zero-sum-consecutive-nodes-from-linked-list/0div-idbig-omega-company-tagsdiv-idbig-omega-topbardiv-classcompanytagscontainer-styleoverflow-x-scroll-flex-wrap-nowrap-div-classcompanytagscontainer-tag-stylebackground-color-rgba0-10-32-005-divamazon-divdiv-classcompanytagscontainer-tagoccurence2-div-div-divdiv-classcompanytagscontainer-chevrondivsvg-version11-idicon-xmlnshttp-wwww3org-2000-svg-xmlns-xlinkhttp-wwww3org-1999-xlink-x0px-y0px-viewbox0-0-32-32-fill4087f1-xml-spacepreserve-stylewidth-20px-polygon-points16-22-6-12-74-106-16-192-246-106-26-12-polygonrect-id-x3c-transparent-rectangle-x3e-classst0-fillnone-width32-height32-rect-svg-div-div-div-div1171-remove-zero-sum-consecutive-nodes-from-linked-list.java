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
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        map.put(0, dummyHead);     //imp step for [1,2,-3,3,1] case
        
        while(head != null) {
            prefixSum += head.val;
            
            //if we found the prefixSum already exists in the map at node start
            //that means from the sum of all nodes between [start.next and node where head is pointing currently] is zero
            //we need to remove those nodes from the list and their entries from the map as well
            //need to map start.next = head.next
            if(map.containsKey(prefixSum)) {
                ListNode start = map.get(prefixSum);
                ListNode temp = start;
                
                int pSum = prefixSum;
                
                while(temp != head) {
                    temp = temp.next;
                    pSum += temp.val;
                    
                    if(temp != head)
                        map.remove(pSum);
                }
                
                start.next = head.next;
            }
            else {
                map.put(prefixSum, head);
            }
            
            head = head.next;
        }
        
        return dummyHead.next;
        
        
    }
}

//T.C : O(n^2)
//S.C : O(n) - We took a map