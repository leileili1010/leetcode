class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
           chars[s.charAt(i++) - 'a']++;
           chars[t.charAt(j++)-'a']--;
        }

        for (int num: chars) {
            if (num != 0) return false;
        }

        return true;
    }
}