class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;

        // two pointers, left pointer and i is the right pointer
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1); //1. 进: 当前i进入遍历窗口
            
            while (map.size() > k) { //2. 出：当前窗口不符合条件是left持续相右边移动缩小窗口
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}