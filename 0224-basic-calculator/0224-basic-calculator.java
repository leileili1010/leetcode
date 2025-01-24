class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        return calculator(chars, 0)[0];
    }

    private int[] calculator(char[] chars, int i) {
        int[] res = new int[2];
        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        
        while (i < chars.length && chars[i] != ')') {
            if (Character.isDigit(chars[i])) {
                stack.push((chars[i]-'0')*sign);
            } else if (chars[i] == '-') {
                sign = -1;
            } else if (chars[i] == '+') {
                sign = 1;
            } else if (chars[i] == '(') {
                int[] newRes = calculator(chars, i+1);
                i = newRes[1];
                stack.push(newRes[0]*sign); 
            } else {
        
            }
            i++;
            res[1] = i; 
        }
        
        for (int num: stack) {
            res[0] += num;
        }
        return res;


    }
}