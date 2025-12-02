class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // corner case
        int m = s1.length();
        if (s2.length() < m) return false;
        
        // count freq for each letter in s1
        int[] cntS1 = new int[26];
        for (char c: s1.toCharArray()) {
            cntS1[c-'a']++;
        }

        char[] s = s2.toCharArray();
        int[] cntS2 = new int[26];
        for (char i = 0; i < s.length; i++) {
            // 1. enter the window
            char c = s[i];
            cntS2[c-'a']++;
            if (i + 1 < m) continue; // window is too small

            // 2. compare two count array
            if (Arrays.equals(cntS1, cntS2)) return true;

            // 3. leave the window, start prep for next window
            cntS2[s[i-m+1] - 'a']--;
        }
        return false;
    }
}