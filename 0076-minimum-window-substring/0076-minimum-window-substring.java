class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return ""; 
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left = 0, validCount = 0, minStart = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0)+1);
                if (window.get(cur).equals(map.get(cur))) validCount++; // must be equal not >=
            }
            
            while (validCount == map.size()) {
                if (i-left+1 < minLen) {
                    minLen = i - left +1;
                    minStart = left;
                }
                
                char c = s.charAt(left);
                if (window.containsKey(c)) {
                    window.put(c, window.get(c)-1);
                    if (window.get(c) < map.get(c)) validCount--;
                }
                left++;
            }
        }
       
        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart+minLen); 
    }
}