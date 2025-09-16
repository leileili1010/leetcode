class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, res = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            while (!set.add(cur)) {
                set.remove(s.charAt(left++));
            }
            
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}