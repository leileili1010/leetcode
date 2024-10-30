class Solution {
    public int lengthOfLongestSubstring(String s) {
       int res = 0, n = s.length();
       HashMap<Character, Integer> map = new HashMap<>();

       for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
           
            if (map.containsKey(c)) {
               i = Math.max(map.get(c), i);
            }
            
            res = Math.max(res, j-i+1);
            map.put(c, j+1);
       }
       return res;
    }
}