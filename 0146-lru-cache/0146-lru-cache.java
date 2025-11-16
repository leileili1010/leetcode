class Node {
    int val;
    int key;
    Node pre;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    } 
}

class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // return get(key), or -1
        // update to be the most recent used
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        moveToTail(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        // if key exists, update value
        // add key-value
            // exceedes capacty: delete least used key in both linkedlist and map
            // add key-value
        // update to be most recent used 
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            
            remove(node);
            moveToTail(node);
            return;
        }

        if (map.size() == capacity) {
            Node delete = head.next;
            map.remove(delete.key);
            remove(delete);
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre= node.pre;
    }

    private void moveToTail(Node node) {
        Node next = tail;
        Node prev = tail.pre;
        node.next = next;
        next.pre = node;
        prev.next = node;
        node.pre = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */