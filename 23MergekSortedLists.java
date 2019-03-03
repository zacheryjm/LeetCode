/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 1) {return lists[0];}
        
        ListNode head = new ListNode(-1);
        ListNode runner = null;
        int numEmptyLists = 0;
        
        while(numEmptyLists < lists.length) {
            numEmptyLists = 0;
            int indexOfLowVal = -1;
            
            for(int i = 0; i < lists.length; ++i) {
                if(lists[i] != null) {
                    if(indexOfLowVal == -1 || lists[i].val < lists[indexOfLowVal].val) {
                        indexOfLowVal = i;
                    }
                }
                else {
                    numEmptyLists++;
                } 
            }
            if(numEmptyLists < lists.length) {
                if(runner == null) {
                    runner = lists[indexOfLowVal];
                    head.next = runner;
                }
                else {
                    runner.next = lists[indexOfLowVal];
                    runner = runner.next;
                }
            
                lists[indexOfLowVal] = lists[indexOfLowVal].next;
            }
        } 
        return head.next;  
    }
}