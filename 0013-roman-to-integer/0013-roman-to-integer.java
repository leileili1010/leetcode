class Solution {
    public int romanToInt(String s) {
        // 1. construct map 
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], nums[i]);
        }

        // 2.
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