class Solution {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] strs = str.toCharArray();
        int left = 0, right = strs.length-1;

        while (left < right) {
            if (strs[left++] != strs[right--]) return false;
        }
        return true;
    }
}