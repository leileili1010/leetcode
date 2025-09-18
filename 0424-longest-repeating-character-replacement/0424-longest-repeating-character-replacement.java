class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, max = 0, res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) { // i = 2
            char cur = s.charAt(i); // cur = 'B'
            map.put(cur, map.getOrDefault(cur, 0)+1); // map: A-2, B-1
            max = Math.max(max, map.get(cur)); // max = 2

            while (i-left+1-max > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                max = Math.max(max, map.get(cur));
                left++;
            }

            res = Math.max(res, i-left+1); // res = 3
        }
        return res;
    }
}