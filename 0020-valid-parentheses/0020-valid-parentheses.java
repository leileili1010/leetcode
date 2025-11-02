class Solution {
    public boolean isValid(String s) {
       // loop s
       // if open bracket, place in stack
       // if close bracket, check the top of the stack, pop or return false;
       // exit loop, return stack.size() == 0;

       Deque<Character> stack = new ArrayDeque<>();

       for (char c: s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                // c is closed bracket
                if (stack.isEmpty()) return false;
                char top = stack.peek();

                if (c == ']' && top != '[' ||
                    c == '}' && top != '{' ||
                    c == ')' && top != '('
                ) {
                    return false;
                } else {
                    stack.pop();
                }
            }
       } 

       return stack.size() == 0;
    }
}