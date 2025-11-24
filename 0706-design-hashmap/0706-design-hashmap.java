class ListNode {
    int key, value;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int SIZE = 10000; 
    private ListNode[] buckets;

    public MyHashMap() {
        buckets = new ListNode[SIZE];
    }
    
    public void put(int key, int value) {
        int idx = getIndex(key);
        if (buckets[idx] == null) {
            buckets[idx] = new ListNode(-1, -1);
        }

        ListNode prev = findPrev(buckets[idx], key);
        ListNode next = prev.next;
        
        if (next == null) {
            prev.next = new ListNode(key, value);
        } else {
            next.value = value;
        }
        
    }
    
    public int get(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) return -1; 

        ListNode prev = findPrev(buckets[index], key);
        if (prev.next == null) return -1;
        return prev.next.value;
    }
    
    public void remove(int key) {
        int index = getIndex(key);
         if (buckets[index] == null) return;
          
        ListNode prev = findPrev(buckets[index], key);
        if (prev.next != null) {
             prev.next = prev.next.next;
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private ListNode findPrev (ListNode head, int key) {
        ListNode curr = head;
        
        while (curr.next != null && curr.next.key != key) {
            curr = curr.next;
        }
        
        return curr;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */