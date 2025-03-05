class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int N = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < N; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(count1, count2)) return true;

        for (int i = N; i < s2.length(); i++) {
            count2[s2.charAt(i)-'a']++;
            count2[s2.codePointAt(i-N)-'a']--;
            if (Arrays.equals(count1, count2)) return true;
        }

        return false;
    }
}