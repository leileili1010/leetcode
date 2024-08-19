class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
            while (left < right && !isValid(left, s)) {
                left++;
            } 

            while (left < right && !isValid(right, s)) {
                right--;
            }

            if (!isEqual(left, right, s)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public boolean isValid(int idx, String s) {
        return Character.isLetterOrDigit(s.charAt(idx));
    }

    public boolean isEqual(int left, int right, String s) {
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right));
    }
}