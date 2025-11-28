class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(left+1, right, s) || isPalindrome(left, right-1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}