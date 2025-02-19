class Solution {
    public boolean isPalindrome(String s) {
        char[] strs = s.toCharArray();
        int left = 0, right = strs.length-1;

        while (left < right) {
            while (left < right && !Character.isLetter(strs[left])) left++;
            while (left < right && !Character.isLetter(strs[right])) right--;
            
            if (Character.toLowerCase(strs[left]) == Character.toLowerCase(strs[right])) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;

    }
}