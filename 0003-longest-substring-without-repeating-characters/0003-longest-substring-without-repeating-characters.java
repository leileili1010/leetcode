class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        boolean[] has = new boolean[128];
        int n = s.length();
        int left = 0;
        int res = 0;

        for (int right = 0; right < n; right++) {
            char curr = chars[right];
            
            while (has[curr]) {
                has[chars[left]] = false;
                left++;
            }

            has[curr] = true;
            res = Math.max(res, right-left+1);
        }
        return res;

    }
}