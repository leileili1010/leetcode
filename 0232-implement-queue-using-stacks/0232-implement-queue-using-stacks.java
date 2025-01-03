class MyQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        // stack2 is used to adjust the order of numbers placed in stack1; 
        // stack1 is the main stack to run every operation
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        
        stack1.push(x);
        
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
        
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */