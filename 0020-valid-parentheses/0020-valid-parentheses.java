class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) { // s 长度必须是偶数
            return false;
        }
        Map<Character, Character> mp = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (mp.containsKey(c)) { // c 是左括号
                st.push(mp.get(c)); // 入栈
            } else if (st.isEmpty() || st.pop() != c) { // c 是右括号
                return false; // 没有左括号，或者左括号类型不对
            }
        }
        return st.isEmpty(); // 所有左括号必须匹配完毕
    }
}

