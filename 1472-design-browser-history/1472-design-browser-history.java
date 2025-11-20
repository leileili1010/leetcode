class BrowserHistory {
    private String curr;
    private Deque<String> backStack;
    private Deque<String> forwardStack;

    public BrowserHistory(String homepage) {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        curr = homepage;
    }
    
    public void visit(String url) {
        backStack.push(curr);
        curr = url;
        forwardStack.clear();
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && !backStack.isEmpty(); i++) {
            forwardStack.push(curr);
            curr = backStack.pop();
        }
        return curr;
     
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !forwardStack.isEmpty(); i++) {
            backStack.push(curr);
            curr = forwardStack.pop();
        }
        return curr;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */