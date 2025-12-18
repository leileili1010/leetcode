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

class LRUCache {
    // hashMap + LinkedList
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail; 

    public LRUCache(int capacity) {
        //  positive size capacity
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        // Return the value of the key if the key exists, otherwise return -1.
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            moveToTail(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // Update the value if the key exists. 
        // Or add the key-value pair to the cache
        // If number of keys > capacity, remove the least recently used key.
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            moveToTail(node);
            return;
        }

        // key does not exist
        // case 1 - exceed capacity
        if (map.size() == capacity) {
            Node remove = head.next;
            removeNode(remove);
            map.remove(remove.key);
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void moveToTail(Node node) {
        Node prev = tail.prev;
        Node next = tail;
        node.prev = prev;
        prev.next = node;
        node.next = next;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */