class Solution {
   public int longestSubstring(String s, int k) {
        int res = 0;
        
        // Iterate over the number of unique characters allowed in the substring
        for (int unique = 1; unique <= 26; unique++) {
            Map<Character, Integer> map = new HashMap<>();
            int left = 0, validCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
                
                // When a character frequency reaches k, it's considered valid
                if (map.get(c) == k) validCount++;

                // Shrink the window if we have more unique characters than allowed
                while (map.size() > unique) {
                    char leftChar = s.charAt(left);
                    if (map.get(leftChar) == k) validCount--;
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) map.remove(leftChar);
                    left++;
                }

                // Check if the current window is valid
                if (map.size() == unique && validCount == unique) {
                    res = Math.max(res, i - left + 1);
                }
            }
        }
        
        return res;
    }
}