class MinStack {
    private Deque<int[]> stack = new ArrayDeque<>(); // int[num, min]

    public MinStack() {
        stack = new ArrayDeque<>();
        stack.push(new int[] {0, Integer.MAX_VALUE});
    }
    
    public void push(int val) {
        stack.push(new int[]{val, Math.min(val, stack.peek()[1])}); 
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}

// stack: [-2, -2], [0, -2], [-3, -3], 

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */