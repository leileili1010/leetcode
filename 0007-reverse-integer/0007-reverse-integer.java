class Solution {
    public int reverse(int x) {
        // x belongs to [-2147483648, 2147483647]
        int n = 0;

        while (x != 0) {
            int remain = x % 10;
            x = x/10;

            if (n > Integer.MAX_VALUE/10 || n == Integer.MAX_VALUE/10 && remain > 7 ) return 0;
            if (n < Integer.MIN_VALUE/10 || n == Integer.MIN_VALUE/10 && remain < -8) return 0;
            
            n = n * 10 + remain;
        }

        return n;
    }
}