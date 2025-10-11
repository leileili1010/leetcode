class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            while (!set.add(cur)) {
                set.remove(s.charAt(left++));
            }

            max = Math.max(max, i-left+1);

        }
        return max;
    }
}