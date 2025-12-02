class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (m < n) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < n; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        for (int i = n; i < m; i++) {
            if (matches == 26) return true;

            int addIdx = s2.charAt(i) - 'a';
            int removeIdx = s2.charAt(i - n) - 'a';

            // Add new char
            count2[addIdx]++;
            if (count2[addIdx] == count1[addIdx]) matches++;
            else if (count2[addIdx] == count1[addIdx] + 1) matches--;

            // Remove old char
            count2[removeIdx]--;
            if (count2[removeIdx] == count1[removeIdx]) matches++;
            else if (count2[removeIdx] == count1[removeIdx] - 1) matches--;
        }
        return matches == 26;
    }
}
