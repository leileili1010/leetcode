class CustomStack {
    List<Integer> list;
    int maxSize;

    public CustomStack(int maxSize) {
        // Initializes the object with maxSize which is the maximum number of elements in the stack
        list = new ArrayList<>();
        this.maxSize = maxSize; // maxSize = 3
    }
    
    public void push(int x) {
        // Adds x to the top of the stack if the stack has not reached the maxSize
        if (list.size() < maxSize) list.add(x); // stack: {1， 2， 3}
    }
    
    public int pop() {
        // Pops and returns the top of the stack or -1 if the stack is empty
        if (list.isEmpty()) return -1;
        int last = list.get(list.size()-1);
        list.remove(list.size()-1);
        return last;
        
    }
    
    public void increment(int k, int val) {
        // Increments the bottom k elements of the stack by val. 
        // If there are less than k elements in the stack, increment all the elements in the stack.
        if (list.isEmpty()) return;
        for (int i = 0; i < k && i < list.size(); i++) {
            list.set(i, list.get(i) + val);
        } 
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */