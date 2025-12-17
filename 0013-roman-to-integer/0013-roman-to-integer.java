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
        char[] strs = s.toCharArray();
        int prev = 0, res = 0;

        for (int i = 0; i < strs.length; i++) {
            int cur = map.get(strs[i]);

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