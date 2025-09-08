class Solution {
    private static class Node {
        char ch;
        int cnt;
        Node(char ch, int cnt) { this.ch = ch; this.cnt = cnt; }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().ch == c) {
                // 同组字符累加
                Node last = stack.peek();
                last.cnt++;
                // 达到 k 就整组删除
                if (last.cnt == k) stack.pop();
            } else {
                stack.push(new Node(c, 1));
            }
        }

        // 还原字符串（从左到右）
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
    Node node = stack.pop();
    for (int i = 0; i < node.cnt; i++) res.append(node.ch);
}
return res.reverse().toString();
    }
}