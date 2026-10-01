/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node newHead = dummy;
        // dummy.next = newHead;

        HashMap<Node, Node> map = new HashMap<>();

        while (head != null) {
            if (!map.containsKey(head)) {
                map.put(head, new Node(head.val));
            }
            Node node = map.get(head);

            Node ran = head.random;
            if (ran != null) {
                if (!map.containsKey(ran)) {
                    Node r = new Node(ran.val);
                    map.put(ran, r);
                }
                node.random = map.get(ran);
            }

            dummy.next = node;
            dummy = dummy.next;
            head = head.next;
        }

        return newHead.next;
    }
}
