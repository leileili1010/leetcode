class Solution {
    class Node {
        private char ch;
        private int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Node> stack = new ArrayDeque<>(); 

        for (char c: s.toCharArray()) {
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