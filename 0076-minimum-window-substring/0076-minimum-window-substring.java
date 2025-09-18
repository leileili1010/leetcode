class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s. length()) return "";
        HashMap<Character, Integer> map = new HashMap<>(); // <letter in t, count>
        HashMap<Character, Integer> window = new HashMap<>(); 
        String res = "";

        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            
            if (map.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0)+1);
                if (window.get(cur).equals(map.get(cur))) count++;
            }

            while (count == map.size()) {
                String sub = s.substring(left, i+1);
                if (res.equals("")) {
                    res = sub;
                } else {
                    if (sub.length() < res.length()) {
                        res = sub;
                    }
                }
                char leftC = s.charAt(left);
                if (map.containsKey(leftC)) {
                    window.put(leftC, window.get(leftC)-1);
                    if (window.get(leftC) < map.get(leftC)) {
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }
}