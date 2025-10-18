class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node exist = map.get(key);
            exist.val = value;
            removeNode(exist);
            moveToTail(exist);
            return;
        }

        if (map.size() == capacity) {
            Node remove = head.next;
            removeNode(remove);
            map.remove(remove.key);
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void removeNode(Node cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }

    private void moveToTail(Node cur) {
        tail.prev.next = cur;
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */