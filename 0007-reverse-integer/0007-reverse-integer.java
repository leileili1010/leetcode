class Solution {
    public int reverse(int x) {
        // 1. isNegative?
        boolean isNegative = x < 0;
        x = Math.abs(x);

        long res = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            res = (long)(res * 10) + digit;
        }

        if (isNegative) res = (long)(-res);
        if (res < Math.pow(2, 31) * -1 || res > Math.pow(2, 31)) return 0;
        return (int)res;
    }
}