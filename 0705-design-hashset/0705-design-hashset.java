class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class MyHashSet {
    ListNode[] buckets;
    private static final int SIZE = 10000;

    public MyHashSet() {
        buckets = new ListNode[SIZE];    
    }
    
    public void add(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new ListNode(-1);
        }

        ListNode prev = findPrev(buckets[index], key);
        
        if (prev.next == null) { // key not found
            prev.next = new ListNode(key);
        } // if key is found, do nothing

    }
    
    public void remove(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) return;

        ListNode prev = findPrev(buckets[index], key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        } 
    }
    
    public boolean contains(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) return false;

        ListNode prev = findPrev(buckets[index], key);
        if (prev.next != null) return true;
        return false;
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private ListNode findPrev(ListNode head, int key) {
        ListNode curr = head;

        while (curr.next != null && curr.next.value != key) {
            curr = curr.next;
        }
        return curr;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */