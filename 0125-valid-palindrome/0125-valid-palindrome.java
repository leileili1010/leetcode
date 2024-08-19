class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while (left < right) {
           while (left < right && !isValid(s, left)) {
                left++;
           } 

           while (left < right && !isValid(s, right)) {
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

    public boolean isValid(String s, int idx) {
        return Character.isLetterOrDigit(s.charAt(idx));
    }

    public boolean isEqual(int left, int right, String s) {
        char char1 = Character.toLowerCase(s.charAt(left));
        char char2 = Character.toLowerCase(s.charAt(right));
        return char1 == char2;
    }
}