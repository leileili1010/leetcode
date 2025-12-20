class Solution {
    public boolean isPalindrome(int x) {
        // x < 0 or x为10的倍数，都不可能是palindrome
        if (x < 0 || x > 0 && x % 10 == 0) {
            return false;
        }

        int rev = 0;
        while (rev < x /10) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == x || rev == x/10;
    }
}