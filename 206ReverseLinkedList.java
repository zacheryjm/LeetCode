/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)  return head;
        
        ListNode tmp = null;
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        
        while(head != null) {
            tmp = head;
            head = head.next;
            tmp.next = prev;
            prev = tmp;    
        }
        
        return prev;
    }
}