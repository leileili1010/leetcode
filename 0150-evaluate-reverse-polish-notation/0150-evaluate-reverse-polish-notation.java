class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String token: tokens) {
            if (token.length() > 1 || Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            stack.push(calcualte(a, b, token));
        }

        return stack.peek();
    }

    private int calcualte(int a, int b, String token) {
        switch(token) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    } 


}