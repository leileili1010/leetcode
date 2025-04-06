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
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node (-1, -1);
        this.tail = new Node (-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        moveToTail(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            get(key);
            return;
        }
        if (map.size() == capacity) {
            Node removeNode = head.next;
            map.remove(removeNode.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    public void moveToTail(Node cur) {
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