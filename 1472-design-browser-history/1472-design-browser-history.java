class BrowserHistory {
    String curr;
    Deque<String> backStack;
    Deque<String> forwardStack;

    public BrowserHistory(String homepage) {
        curr = homepage;
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
    }
    
    public void visit(String url) {
        backStack.push(curr);
        if (!forwardStack.isEmpty()) forwardStack.clear();
        curr = url;
    }
    
    public String back(int steps) {
        while (!backStack.isEmpty() && steps > 0) {
            forwardStack.push(curr);
            curr = backStack.pop();
            steps--;
        }

        return curr;
    }
    
    public String forward(int steps) {
        while (!forwardStack.isEmpty() && steps > 0) {
            backStack.push(curr);
            curr = forwardStack.pop();
            steps--;
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