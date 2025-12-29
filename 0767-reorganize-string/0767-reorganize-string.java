class Solution {
    public String reorganizeString(String s) {
        // 1. 统计freq for each letter
        // 2. maxFreq and maxChar
        // 3. will we have a valid result?
        // 4. update char[n] result 
            // put maxChar on even index
            // put the rest even/odd index
        
        int[] freq = new int[26];
        for (char c: s.toCharArray()) freq[c-'a']++;

        int maxFreq = 0, maxChar = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxChar = i;
            }
        }

        int n = s.length();
        if (maxFreq > (n+1) / 2) return "";

        char[] res = new char[n];
        int idx = 0;
        while (freq[maxChar]-- > 0) {
            res[idx] = (char)(maxChar + 'a');
            idx += 2;
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                if (idx >= n) idx = 1;
                res[idx] = (char)(i + 'a');
                idx += 2;
            }
        }
        return new String(res);

    }
}