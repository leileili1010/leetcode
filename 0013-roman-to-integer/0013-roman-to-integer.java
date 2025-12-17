class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
  
        int prev = Integer.MAX_VALUE, res = 0;
        for (char c: s.toCharArray()) {
            int cur = map.get(c);

            if (prev == 0 || cur <= prev) {
                res += cur;
            } else {
                res += cur - 2*prev;
            }
            prev = cur;
        }
        return res;
    }
}