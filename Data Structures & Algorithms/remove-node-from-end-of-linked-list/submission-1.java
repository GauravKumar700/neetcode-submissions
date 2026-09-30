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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        
        if(n == size && head != null){
            return head.next;
        }
        
        curr = head;
        
        for (int i = 1; i <= size - n; i++) {
            prev = curr;
            if (curr != null) {
                curr = curr.next;
            }
        }
        if (prev != null && curr != null) {
            prev.next = curr.next;
        }
        return head;
    }
}
