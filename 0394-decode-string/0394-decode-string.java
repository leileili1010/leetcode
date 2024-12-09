class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> intStack = new ArrayDeque<>();
        Deque<StringBuilder> sbStack = new ArrayDeque<>();
        int n = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                intStack.push(n);
                n = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else {
                int k = intStack.pop();
                StringBuilder temp = sb;
                sb = sbStack.pop();
                while (k > 0) {
                    sb.append(temp);
                    k--;
                }
            }
        }

        return sb.toString();
    }
}