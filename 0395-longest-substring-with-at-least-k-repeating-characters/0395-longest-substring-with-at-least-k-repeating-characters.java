class Solution {
    public int longestSubstring(String s, int k) {
        return findLongestSubstring(s, 0, s.length(), k);
    }

    private int findLongestSubstring(String s, int start, int end, int k) {
        // 1. base case
        if (end < k) return 0;

        // count map
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[s.charAt(i)-'a']++;
        }

        // 3.1 find split
        for (int mid = start; mid < end; mid++) {
            if (count[s.charAt(mid)-'a'] >= k) continue;
            int midNext = mid+1;
            while (midNext < end && count[s.charAt(midNext)-'a'] < k) {
                midNext++;
            }
            return Math.max(findLongestSubstring(s, start, mid, k), findLongestSubstring(s, midNext, end, k));
        }

        // 3.2 if the whole string is valid, return the string length;
        return (end-start);
    }
}