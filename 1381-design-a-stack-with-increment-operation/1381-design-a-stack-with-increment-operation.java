class CustomStack {
    int[] stack;
    int[] add;
    int top;
 
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        add = new int[maxSize];
        top = -1;
    }
    
    
    public void push(int x) {
        if (top + 1 < stack.length) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) return -1;

        int res = stack[top] + add[top];
        if (top != 0) {
            add[top-1] += add[top];
        }
        add[top] = 0;
        top--;
        return res;
    }
    
    
    public void increment(int k, int val) {
        int limit = Math.min(k-1, top);
        if (limit >= 0) {
            add[limit] += val;
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