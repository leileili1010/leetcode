class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int windowSize = s1.length();
       
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }

        if (Arrays.equals(count1, count2)) return true;

        for (int i = windowSize; i < s2.length(); i++) {
            char cur = s2.charAt(i);
            count2[cur-'a']++;
            count2[s2.charAt(i-windowSize)-'a']--;
            if (Arrays.equals(count1, count2)) return true;

        }
        return false;
    }
}