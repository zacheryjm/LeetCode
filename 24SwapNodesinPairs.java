/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null) {
            return head;
        }
        
        //Pointer to front of list
        ListNode headPointer = new ListNode(-1);
        headPointer.next = head;
        
        //Pointer to keep track of list before current node
        ListNode previous = headPointer;
        
        //Pointer to move through each pair of nodes
        ListNode current = head; 
        
        ListNode nextNode = current.next;
        
        while (nextNode != null) {
            //Swap adjacent nodes while keeping the full list linked together.
            current.next = nextNode.next;
            nextNode.next = current;
            previous.next = nextNode;
            previous = current;
            
            //Move pointer to next adjacent pair in List
            if (current.next != null) {
                current = current.next;
                nextNode = current.next;    
            }
            else {
                nextNode = null;
            }    
            
            
        }
        
        return headPointer.next;
    }
}