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
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                dummy.next = node1;
                dummy = dummy.next;
                node1 = node1.next;
            } else {
                dummy.next = node2;
                dummy = dummy.next;
                node2 = node2.next;
            }
        }

        if (node1 != null) {
            dummy.next = node1;
        }

        if (node2 != null) {
            dummy.next = node2;
        }

        return head.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = dummy;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] == null) continue;
            ListNode temp = merge(node, lists[i]);
            lists[i] = temp;
            node = temp;
        }
        return dummy.next;
    }
}
