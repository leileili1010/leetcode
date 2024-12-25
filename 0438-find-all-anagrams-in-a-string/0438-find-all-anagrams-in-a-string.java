class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] target = new int[26];
        int[] current = new int[26];

        for (char c: p.toCharArray()) {
            target[c - 'a']++;
        } 

        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            current[s.charAt(i) - 'a']++;
            if (i-left+1 == p.length()) {
                if (Arrays.equals(current, target)) {
                    res.add(left);
                }
                current[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return res;
    }
}