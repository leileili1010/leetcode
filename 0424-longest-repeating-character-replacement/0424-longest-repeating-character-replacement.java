class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, n = s.length();
        int res = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0)+1);
            if (map.get(curr) > max) max = map.get(curr);

            while (i-left+1-max > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                left++;
            }

            res = Math.max(res, i-left+1);
        }
        return res;
    }
}