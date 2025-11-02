class Node {
    char letter;
    int count;

    public Node(char letter, int count) {
        this.letter = letter;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        // loop s
        // if stack is empty, simply put node inside
        // if not, compare current char to stack.peek()
            // if different, simply put inside
            // if same, update count;
            // count == k, pop
        // construct return string

        Deque<Node> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().letter == c) {
                Node top = stack.peek();
                top.count += 1;
                if (top.count == k) stack.pop();
            } else {
                stack.push(new Node(c,1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node: stack) {
            for (int i = 0; i < node.count; i++) {
                sb.append(node.letter);
            }
        }

        return sb.reverse().toString();
    }
}