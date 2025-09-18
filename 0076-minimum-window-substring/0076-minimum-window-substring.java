class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left = 0, count = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (map.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0)+1);
                if (window.get(cur).equals(map.get(cur))) count++;
            }

            while (count == map.size()) {
                int len = i-left+1;
                if (len < minLen ) {
                    minStart = left;
                    minLen = i-left+1;
                }
                
                char c = s.charAt(left);
                if (window.containsKey(c)) {
                    window.put(c, window.get(c)-1);
                    if (window.get(c) < map.get(c)) count--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE? "": s.substring(minStart, minStart+minLen);
    }
}