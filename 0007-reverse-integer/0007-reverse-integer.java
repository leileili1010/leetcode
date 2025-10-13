class Solution {
    public int reverse(int x) {                    
        boolean isNegative = x < 0;
        x = Math.abs(x);

        long res = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            res = res * 10 + digit;
        }

        if (isNegative) res = -res;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }
}