class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int odd = 0, even = 0;

        for (char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (int value: map.values()) {
            if (value % 2 == 0) {
                even += value;
            } else if (value % 2 == 1) {
                odd = Math.max(odd, value);
            }
        } 

        return odd + even;
    }
}