class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // longest, substring, at most k distinct
        // return int length/count
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);

            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) map.remove(c);
                left++;
            }

            count = Math.max(count, i-left+1);
        }
        return count;
        
    }
}

// map
// e: 1