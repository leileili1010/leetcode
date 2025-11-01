class Solution {
    public boolean equalFrequency(String word) {
        // 1. frequency of each letter of word
        int[] freq = new int[26];
        for (char c: word.toCharArray()) freq[c-'a']++;

        // 2. loop through each freq minus-- to see if we can find the answer
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;
            if (isEqual(freq)) return true;
            freq[i]++;
        }

        return false;
    }
    
    // helper function;
    private boolean isEqual(int[] freq) {
        int count = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            
            if (count == 0) {
                count = freq[i];
            } else {
                if (count != freq[i]) return false;
            }    
        }

        return true;
    }
}