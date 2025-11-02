class Solution {
    public String decodeString(String s) {
        Deque<Integer> intStack = new ArrayDeque<>();
        Deque<StringBuilder> letterStack = new ArrayDeque<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c-'0');
            } else if (c == '[') {
                intStack.push(n);
                letterStack.push(sb);
                n = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                int k = intStack.pop();
                StringBuilder temp = sb;
                sb = letterStack.pop();

                for (int i = 0; i < k; i++) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}