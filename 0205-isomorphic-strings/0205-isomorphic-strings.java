class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        boolean[] used = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1) && map.get(c1) == c2) continue;
            if (map.containsKey(c1) || used[c2]) return false;

            map.put(c1, c2);
            used[c2] = true;
        }
        return true;
    }
}