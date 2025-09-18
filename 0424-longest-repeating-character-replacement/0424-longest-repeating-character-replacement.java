class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, res = 0, maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            count[cur-'A']++;
            maxCount = Math.max(maxCount, count[cur-'A']); //用于记录当下字母出现的最高频率

            while ((i-left+1) - maxCount > k) {
                char c = s.charAt(left);
                count[c-'A']--;
                maxCount = Math.max(maxCount, count[c-'A']);
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}