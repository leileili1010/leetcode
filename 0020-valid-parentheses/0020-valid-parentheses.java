class Solution {
    public boolean isValid(String S) {
        if (S.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        char[] s = S.toCharArray();
        int top = 0; // 直接把 s 当作栈
        for (char c : s) {
            if (c == '(') {
                s[top++] = ')'; // 入栈对应的右括号
            } else if (c == '[') {
                s[top++] = ']';
            } else if (c == '{') {
                s[top++] = '}';
            } else if (top == 0 || s[--top] != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return top == 0; // 所有左括号必须匹配完毕
    }
}