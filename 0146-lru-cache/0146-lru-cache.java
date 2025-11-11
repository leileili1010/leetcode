class ListNode {
    ListNode prev;
    ListNode next;
    int val;
    int key;

    public ListNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>(); 
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        ListNode node = map.get(key);
        remove(node);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            moveToTail(node);
            return;
        }        

        if (map.size() == capacity) {
            ListNode toRemove = head.next;
            remove(toRemove);
            map.remove(toRemove.key);
        }
        ListNode insert = new ListNode(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToTail(ListNode node) {
        ListNode prev = tail.prev;
        ListNode next = tail;
        prev.next = node;
        node.prev = prev;
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