class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") ||
                token.equals("/") || token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                res = calculate(a, b, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private int calculate(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            case "*":
                return a * b;
            default:
                return a + b;
        }
    }
}