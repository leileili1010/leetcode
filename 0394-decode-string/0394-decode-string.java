class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c-'0');
            } else if (c == '[') {
                intStack.push(n);
                n = 0;
                sbStack.push(sb);
                sb = new StringBuilder();
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else {
                StringBuilder temp = sb;
                sb = sbStack.pop();
                int k = intStack.pop();
                while (k > 0) {
                    sb.append(temp);
                    k--;
                }
            }

        }
        return sb.toString();
    }
}