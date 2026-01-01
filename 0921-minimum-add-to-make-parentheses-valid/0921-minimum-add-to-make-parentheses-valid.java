class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            else if (stack.isEmpty() || stack.peek() != '('){
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        return stack.size();
    }
}