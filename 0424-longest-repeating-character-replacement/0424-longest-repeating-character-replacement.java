class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length(), left = 0;
        Map<Character, Integer> map = new HashMap<>();

        int max = 0, res = 0;
        for (int i = 0; i < N; i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);
            max = Math.max(max, map.get(cur));

            while (i-left+1 - max > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                left++;
            }

            res = Math.max(res, i-left+1);
        }
        return res;
    }
}