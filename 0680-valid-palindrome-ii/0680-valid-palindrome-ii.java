class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n-1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else {
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            }
        } 

        return true;
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}