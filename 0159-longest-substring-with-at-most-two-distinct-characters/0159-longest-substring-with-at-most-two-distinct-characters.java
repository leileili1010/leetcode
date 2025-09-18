class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;

        for (int i = 0; i < s.length(); i++) { // i = 4
            char cur = s.charAt(i); // cur = 'b'
            map.put(cur, map.getOrDefault(cur, 0)+1);

            while (map.size() > 2) { // set: c, a, b
                char c = s.charAt(left); // c = 'b'
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            } 

            res = Math.max(res, i-left+1); // res = 4
        }
        return res;
    }
}