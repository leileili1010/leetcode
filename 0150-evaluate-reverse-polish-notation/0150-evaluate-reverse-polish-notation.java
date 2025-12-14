class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>(); // 更快的写法见
        for (String token : tokens) {
            char c = token.charAt(0);
            if (token.length() > 1 || Character.isDigit(c)) { // token 是数字
                st.push(Integer.parseInt(token));
                continue;
            }

            int x = st.pop();
            int y = st.pop(); // 无法直接修改栈顶
            if (c == '+') {
                st.push(y + x);
            } else if (c == '-') {
                st.push(y - x);
            } else if (c == '*') {
                st.push(y * x);
            } else {
                st.push(y / x);
            }
        }
        return st.peek();
    }
}