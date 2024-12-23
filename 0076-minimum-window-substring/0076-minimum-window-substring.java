class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
         for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        int left = 0, count = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) count++; 
                map.put(cur, map.get(cur)-1); 
            }

            while (count == t.length()) { 
                if (i - left + 1 < minLen) {
                    minStart = left;
                    minLen = i - left + 1;
                }

                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c)+1); 
                    if (map.get(c) > 0) count--; 
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart+minLen);
    }
}