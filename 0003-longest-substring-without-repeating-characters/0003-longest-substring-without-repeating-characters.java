class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            
            while (set.contains(r)) {
                char l = s.charAt(left);
                set.remove(l);
                left++;
            }

            set.add(r);
            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}