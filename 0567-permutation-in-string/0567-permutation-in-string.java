class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] count1 = new int[26], count2 = new int[26];
        int N = s1.length();

        for (int i = 0; i < N; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(count1, count2)) return true;

        int left = 0;
        for (int i = N; i < s2.length(); i++) {
            char cur = s2.charAt(i);
            count2[cur-'a']++;
            char c = s2.charAt(left);
            count2[c-'a']--;
            left++;

            if (Arrays.equals(count1, count2)) {
                return true;
            }
        } 

        return false;
    }
}