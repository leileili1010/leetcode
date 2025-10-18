class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> remove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // No matching '(' → mark for removal
                    remove.add(i);
                } else {
                    stack.pop(); // matched
                }
            }
        }

        // Remaining '(' are unmatched
        while (!stack.isEmpty()) {
            remove.add(stack.pop());
        }

        // Build valid string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
