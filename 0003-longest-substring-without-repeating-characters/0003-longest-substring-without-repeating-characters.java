class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            while (!set.add(cur)) {
                char c = s.charAt(left);
                set.remove(c);
                left++;
            }
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}