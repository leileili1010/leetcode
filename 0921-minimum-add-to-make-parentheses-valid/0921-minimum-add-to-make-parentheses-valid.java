class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0; // 未匹配的 '(' 数量
        int res = 0;     // 需要补充的括号数

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else { // c == ')'
                if (balance > 0) {
                    balance--;
                } else {
                    res++; // 补一个 '('
                }
            }
        }

        // 剩余的 '(' 需要补 ')'
        return res + balance;
    }
}
