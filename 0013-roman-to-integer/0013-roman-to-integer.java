class Solution {
    public int romanToInt(String s) {
        char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = {1,5,10,50,100,500,1000};
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], values[i]);
        }

        int res = 0;
        int pre = 0;
        for (char c: s.toCharArray()) {
            int cur = map.get(c);
            if (cur > pre) {
                res += cur;
            } else {
                res += cur - 2 * pre;
            }
            pre = cur;
        }
        return res;  
    }
}