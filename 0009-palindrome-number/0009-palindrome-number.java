class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        long reverse = 0;
        int num = x;
        while (num != 0) {
            int digit = num % 10; // digit = 1
            num = num / 10; // x = 0
            reverse = 10 * reverse + digit; // reverse = 121
        }

        return reverse == x;

    }
}