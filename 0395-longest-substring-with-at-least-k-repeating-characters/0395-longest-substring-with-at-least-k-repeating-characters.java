class Solution {
    public int longestSubstring(String s, int k) {
        int res = 0;
        
        for (int unique = 1; unique <= 26; unique++) {
            int left = 0, validCount = 0;
            HashMap<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                map.put(cur, map.getOrDefault(cur, 0)+1); 
                if (map.get(cur) == k) validCount++;

                while (map.size() > unique) {
                    char c = s.charAt(left);
                    map.put(c, map.get(c)-1);
                    if (map.get(c) == k-1) validCount--;
                    if (map.get(c) == 0) map.remove(c);
                    left++;
                }

                if (validCount == unique) res = Math.max(res, i-left+1);
                
            }
        }
        return res;


    }
}