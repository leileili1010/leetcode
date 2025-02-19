class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
            } else if (!isValid(s.charAt(right))) {
                right--;
            } else if (!isEqual(s, left, right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValid(char c) {
        return Character.isLetterOrDigit(c);
    }

    private boolean isEqual(String s, int left, int right) {
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right));
    }
}