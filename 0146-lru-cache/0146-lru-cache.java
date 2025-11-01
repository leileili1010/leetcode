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
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // get key or return -1 if key does not exist
        // O(1)
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        remove(node);
        moveToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        // update key value or add key-value pair
        // if capacity exceeded, remove the least used key
        // O(1)
        
        // case 1: Key existes, simply update
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToTail(node);
            return;
        }

        // case 2: key does not exists and capacity exceeded
        if (capacity == map.size()) {
            Node remove = head.next;
            remove(remove);
            map.remove(remove.key);
        }   

        // case 3: insert
        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToTail(Node node) {
        Node prev = tail.prev;
        Node next = tail;
        
        node.prev = prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node; 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */