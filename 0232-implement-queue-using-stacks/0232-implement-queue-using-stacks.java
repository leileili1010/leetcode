class MyQueue {
    private Deque<Integer> que;

    public MyQueue() {
        que = new ArrayDeque<>();
    }
    
    public void push(int x) {
        que.offer(x);
    }
    
    public int pop() {
        return que.poll();
    }
    
    public int peek() {
        return que.peek();
        
    }
    
    public boolean empty() {
        return que.isEmpty();
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