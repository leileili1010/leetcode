class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, n = s.length();
        int left = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            while (!set.add(c)) {
                char letter = s.charAt(left);
                set.remove(letter);
                left++;
            }

            max = Math.max(max, i-left+1);
        }

        return max;
    }
}