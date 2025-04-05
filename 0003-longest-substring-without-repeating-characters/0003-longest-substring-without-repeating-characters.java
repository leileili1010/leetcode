class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), res = 0, right = 0, left = 0;
        char[] chars = new char[128];

        while (right < n) {
            char ch = s.charAt(right);
            
            while (chars[ch] > 0 ) {
                char r = s.charAt(left);
                chars[r]--;
                left++;
            }

            res = Math.max(res, right-left+1);
            chars[ch]++;
            right++;


        }
        
        return res;
    }
}