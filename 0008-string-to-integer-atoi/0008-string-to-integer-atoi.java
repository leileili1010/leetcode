class Solution {
    public int myAtoi(String s) {
        // check if it is an empty string (excluding leading spaces)
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        // 1. Skip leading spaces;
        int i = 0;
        // while (s.charAt(i) == ' ') {
        //     i++;
        // }

        // 2. Handle sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = s.charAt(i++) == '-'? -1: 1;
        }

        // 3. Convert number
        int res = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (checkIntOverflow(res, s.charAt(i) - '0')) {
                return (sign == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            
            res = res * 10 + (s.charAt(i++) - '0');
        }

        return res * sign;
    }

    private boolean checkIntOverflow(int res, int lastDigit) {
        return (res > Integer.MAX_VALUE/10) ||
            (res == Integer.MAX_VALUE/10 && lastDigit > Integer.MAX_VALUE % 10); 
    }
}