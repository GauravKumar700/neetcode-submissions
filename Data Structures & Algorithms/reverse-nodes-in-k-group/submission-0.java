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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        int count = 1;
        ListNode temp = null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;

        while(head != null){
            if(temp == null){
                temp = head;
            }
            if(count == k){
                ListNode next = head.next;
                head.next = null;
                prev.next = reverse(temp);
                prev = temp;
                head = next;
                temp = null;
                count = 1;
                continue;
            }
            head = head.next;
            count++;
        }
        if(count > 1){
            prev.next = temp;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
