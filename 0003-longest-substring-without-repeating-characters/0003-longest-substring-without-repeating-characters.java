class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int left = 0; 

        // i is the right pointer
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // i = 0, c = a
            while (set.contains(c)) {
                set.remove(s.charAt(left++));
            }
            set.add(c); //set = [a]
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}