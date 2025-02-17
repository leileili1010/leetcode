class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        moveToTail(cur);
        return cur.val;
        
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existNode = map.get(key);
            existNode.val = value;
            get(key); // smart way to remove old value
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
        cur.next = tail;
        cur.prev = tail.prev;
        tail.prev.next = cur;
        tail.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */