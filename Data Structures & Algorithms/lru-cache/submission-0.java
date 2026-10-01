class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int size;
    HashMap<Integer, Node> map;
    Node head;
    Node last;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.map = new HashMap<>();
        head = new Node(0,0);
        last = new Node(0,0);
        head.next = last;
        last.prev = head;
    }

    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void addToEnd(Node node){
        Node prev = last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = last;
        last.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);

            remove(curr);
            addToEnd(curr);

            return curr.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size <= 0) {
            return;
        }
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToEnd(node);
        }else{
            Node node = new Node(key,value);
            addToEnd(node);
            map.put(key,node);

            if(map.size() > size){
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}
