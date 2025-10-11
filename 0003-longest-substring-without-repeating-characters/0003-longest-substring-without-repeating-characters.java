class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0, res = 0;
        for (int i =0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (!set.add(c)) {
                char letter = s.charAt(left);
                set.remove(letter);
                left++;
            }

            res = Math.max(res, i-left+1);
        }
        return res;
    }
}