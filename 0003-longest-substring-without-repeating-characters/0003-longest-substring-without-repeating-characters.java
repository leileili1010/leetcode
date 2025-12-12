class Solution {
    public int lengthOfLongestSubstring(String s) { // s = "abcabcbb"
        Set<Character> set = new HashSet<>();
        int left = 0, res = 0;

        for (int i = 0; i < s.length(); i++) { // i = 4
            char cur = s.charAt(i); // cur = b

            while (!set.add(cur)) { // set = cab
                char c = s.charAt(left); // c = b
                set.remove(c); // set = ca
                left++; // left = 1
            }

            res = Math.max(res, i-left+1); // 3
        }
        return res;
    }   
}