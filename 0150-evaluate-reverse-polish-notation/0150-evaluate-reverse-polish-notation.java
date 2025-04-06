class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str: tokens) {
           if (isOperationSign(str)) {
                int y = stack.pop();
                int x = stack.pop();
                int result = calculator(x, y, str);
                stack.push(result);
           } else {
                stack.push(Integer.parseInt(str));
           }
        }
        
        return stack.peek();
    }

    private boolean isOperationSign(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int calculator(int x, int y, String token) {
        if (token.equals("+")) return x + y;
        if (token.equals("-")) return x - y;
        if (token.equals("*")) return x * y;
        return x/y;
    }

}