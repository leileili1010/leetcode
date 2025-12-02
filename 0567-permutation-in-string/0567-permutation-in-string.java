class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // count frequency for each letter in s1
        // use sliding window of s1.length() to count letter for s2 letter frequency
        // compare those two frequency arrays, equal return true

        // corner case
        int m = s1.length();
        if (s2.length() < m) return false;

        int[] count = new int[26];
        int less = 0;
        for (char c: s1.toCharArray()) {
            if (count[c-'a'] == 0) less++;
            count[c-'a']++;
        }

        char[] s = s2.toCharArray();
        for (int i = 0; i < s.length; i++) {
            int idx = s[i]-'a';
            count[idx]--;
            if (count[idx] == 0) less--;

            if (i + 1 < m) continue;

            if (less == 0) return true;

            int out = s[i-m+1]-'a';
            if (count[out] == 0) {
                less++;
            }
            count[out]++;
        }

        return false;
    }
}