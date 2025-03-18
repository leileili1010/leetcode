class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            while (set.contains(cur)) {
                char c = s.charAt(left);
                set.remove(c);
                left++;
            }
            set.add(cur);
            max = Math.max(max, i - left +1);
        }
        return max;
    }
}