class Solution {
    public int lengthOfLongestSubstring(String s) { // s = "abcabcbb"
        char[] chars = s.toCharArray();
        boolean[] has = new boolean[128];
        int left = 0, res = 0;

        for (int i = 0; i < chars.length; i++) { // i = 4
            char cur = chars[i]; // cur = b

            while (has[cur]) { // set = cab
                char c = chars[left]; // c = b
                has[c] = false; // set = ca
                left++; // left = 1
            }

            has[cur] = true;
            res = Math.max(res, i-left+1); // 3
        }
        return res;
    }   
}