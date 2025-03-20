class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;

        for (int unique = 1; unique <= 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, valid = 0;

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0)+1);
                if (map.get(cur) == k) valid++;

                while (map.size() > unique) {
                    char c = s.charAt(left);
                    map.put(c, map.get(c)-1);
                    if (map.get(c) == k-1) valid--;
                    if (map.get(c) == 0) map.remove(c);
                    left++;
                }

                if (valid == unique) {
                    res = Math.max(res, i-left+1);
                }
            }
        }


        return res;
    }
}