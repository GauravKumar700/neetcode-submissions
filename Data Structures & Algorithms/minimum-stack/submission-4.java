class MinStack {
    private class Node {
        Integer value;
        Integer min;
        Node next;
        public Node() {
            
        }
        public Node(int val) {
            this.value = val;
        }
    }

    private Node top;
    private Integer minimum;

    public MinStack() {
        this.top = null;
        this.minimum = null;
    }

    public void push(int val) {
        Node nd = new Node(val);
        nd.next = top;
        nd.min = minimum;
        minimum = minimum != null ? Math.min(minimum,val) : val;
        top = nd;
    }

    public void pop() {
        if (top != null) {
            if(minimum.equals(top.value)){
                minimum = top.min;
            }
            top = top.next;
        }
    }

    public int top() {
        return top != null ? top.value : -1;
    }

    public int getMin() {
        return minimum;
    }
}
