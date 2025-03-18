class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCout = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            count[cur-'A']++;
            maxCout = Math.max(count[cur-'A'], maxCout);
            
            while (i-left+1 - maxCout > k) {
                char c = s.charAt(left);
                count[c-'A']--;
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}