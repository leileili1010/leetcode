class Solution {
    public int myAtoi(String s) {
        // requiremnts:
        // 1. ignore leading spaces
        // 2. ignore leading zeros
        // 3. sign: "-" and " +"/""
        // 4. Stop once non-digit character is encountered
        // 5. if overflow, round to integer range

        int sign = 1;
        boolean start = false;
        long res = 0;

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == ' ' && !start) {
                i++;
            }

            if (i < s.length() && (s.charAt(i) =='-' || s.charAt(i) == '+') && !start) {
                if (s.charAt(i) == '-') {
                    sign = -1;
                } 
                i++;
            }

            while (i < s.length() && s.charAt(i) == '0' && !start) {
                i++;
            }

            start = true; 

            if (i < s.length() && !Character.isDigit(s.charAt(i))) {
                break;
            }

            if (i < s.length()) {
                res = res * 10 + Character.getNumericValue(s.charAt(i));

                if (sign == 1 && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }

       
        return (int)res*sign;
    }
}