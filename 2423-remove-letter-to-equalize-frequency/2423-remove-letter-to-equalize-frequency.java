class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        for (char c: word.toCharArray()) freq[c-'a']++;

        for (int i = 0; i< freq.length; i++) {
            freq[i]--;
            if (isEqual(freq)) return true;
            freq[i]++;
        }
        return false;
    }

    private boolean isEqual(int[] freq) {
        int target = 0;
        for (int num: freq) {
            if (num == 0) continue;
            if (target == 0) target = num;
            if (target != num) return false;
        }
        return true;
    }
}