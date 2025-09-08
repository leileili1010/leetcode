class Solution {
    class Node {
        char ch;
        int count;
        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().ch == c) {
                Node last = stack.peek();
                last.count += 1;
                if (last.count == k) stack.pop();
            } else {
                stack.push(new Node(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node: stack) {
            for (int i = 0; i < node.count; i++) {
                sb.append(node.ch);
            }
        }

        return sb.reverse().toString();
    }
}