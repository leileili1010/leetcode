class Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> intStack = new ArrayDeque<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c-'0');
            } else if (c == '[') {
                strStack.push(sb);
                sb = new StringBuilder();
                intStack.push(n);
                n = 0;
            } else if (c == ']') {
                int k = intStack.pop();
                StringBuilder temp = sb;
                sb = strStack.pop();
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