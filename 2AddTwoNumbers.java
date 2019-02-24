/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = new ListNode(-1);
        ListNode current = head;
        Boolean carry = false;
        
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        
        while(l1Runner != null && l2Runner != null) {
            int sum = l1Runner.val + l2Runner.val;
            
            if(carry) {
                sum++;
                carry = false;
            }
            
            if((sum / 10) != 0) {
                sum = sum % 10;
                carry = true;
            }
            
            ListNode sumNode = new ListNode(sum);
            current.next = sumNode;
            current = current.next;
            
            l1Runner = l1Runner.next;
            l2Runner = l2Runner.next;
        }
        
        if(l1Runner != null) {
            if(carry) {
                addCarryToList(current, l1Runner);
            } else {
                current.next = l1Runner;
            }
        }
        else if(l2Runner != null) {
            if(carry) {
                addCarryToList(current, l2Runner);
            } else {
                current.next = l2Runner;
            }
        }
        else if(carry) {
            ListNode finalNode = new ListNode(1);
            current.next = finalNode;
            current = current.next;
        }
        
        return head.next;
    }
    
    public void addCarryToList(ListNode current, ListNode ln) {
        Boolean carry = true;
        
        while(carry) {
            int sum = ln.val + 1;
            carry = false;
            
            if(sum / 10 != 0) {
                sum = sum % 10;
                carry = true;
            }
            
            ListNode sumNode = new ListNode(sum);
            current.next = sumNode;
            current = current.next;
            ln = ln.next;
            
            if (ln == null && carry) {
                ListNode finalNode = new ListNode(1);
                current.next = finalNode;
                current = current.next;
                break;
            }
        }
        current.next = ln;
    }
}