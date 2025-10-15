class Solution {
    int start = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, 0); //假设subarray是基数
            helper(s, i, 1); // 假设subarray是偶数
        }

        return s.substring(start, start + maxLen);
    }

    private void helper(String s, int idx, int offset) {
        int left = idx, right = idx + offset;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            
        }

        left++; //走过了要退回一步
        right--; //走过了要退回一步
        if (right - left + 1 > maxLen) {
            start = left;
            maxLen = right - left + 1;
        }
    }
}