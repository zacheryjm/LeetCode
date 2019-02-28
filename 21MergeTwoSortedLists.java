/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(-1);
        ListNode sortedList = head;

        while (l1 != null && l2 != null) {
            
            if(l1.val < l2.val) {
                sortedList.next = l1;
                l1 = l1.next;
            }
            else {
                sortedList.next = l2;
                l2 = l2.next;
            }
            
            sortedList = sortedList.next;
        }
        
        if(l1 != null) {
            sortedList.next = l1;
        }
        else if(l2 != null) {
            sortedList.next = l2;
        }
        
        return head.next;
    }
}