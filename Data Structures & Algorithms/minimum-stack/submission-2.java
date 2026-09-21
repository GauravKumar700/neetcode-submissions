class MinStack {
    private class Node {
        int value;
        Node next;
        public Node() {
            this.value = 0;
            this.next = null;
        }
        public Node(int val) {
            this.value = val;
        }
    }

    private Node top;
    private PriorityQueue<Integer> min;

    public MinStack() {
        Node node = new Node();
        this.top = node;
        this.min = new PriorityQueue<>();
    }

    public void push(int val) {
        Node nd = new Node(val);
        nd.next = top;
        top = nd;
        min.offer(val);
    }

    public void pop() {
        if (top != null) {
            min.remove(top.value);
            top = top.next;
        }
    }

    public int top() {
        if (top != null) {
            return top.value;
        }
        return -1;
    }

    public int getMin() {
        if (min.size() > 0) {
            return min.peek();
        }
        return -1;
    }
}
