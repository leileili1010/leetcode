class BrowserHistory {
    private Deque<String> backStack;
    private Deque<String> forwardStack;
    private String current; 

    public BrowserHistory(String homepage) {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        current = homepage;
    }
    
    public void visit(String url) {
        backStack.push(current);
        if (!forwardStack.isEmpty()) forwardStack.clear();
        current = url;
    }
    
    public String back(int steps) {
        while (!backStack.isEmpty() && steps > 0) {
            forwardStack.push(current);
            current = backStack.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps > 0) {
            backStack.push(current);
            current = forwardStack.pop();
            steps--;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */