class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        int idx = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char ch = stack.pop();
                if (ch !='{' && c == '}') return false;
                if (ch !='[' && c == ']') return false;
                if (ch !='(' && c == ')') return false;
            }
            idx++;
        }
        return stack.isEmpty();
    }
}