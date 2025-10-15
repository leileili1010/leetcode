class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c: word.toCharArray()) freq[c-'a']++;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;
            if (isEqual(freq)) return true;
            freq[i]++;
        }
        return false;
    }

    private boolean isEqual(int[] freq) {
        int target = 0;
        for (int count: freq) {
            if (count == 0) continue;
            if (target == 0) target = count;
            else if (count != target) return false;
        }
        return true;
    }
}