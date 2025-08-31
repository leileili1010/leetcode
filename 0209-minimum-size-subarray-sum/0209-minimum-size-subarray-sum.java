class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0, 0);
        int sum = 0, minLen = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) { // i = 5
            sum += nums[i]; // sum = 15
            if (map.containsKey(sum-target)) { // 8 true,
                int len = i+1-map.get(sum-target); // 5+1-4 = 2
                minLen = Math.min(minLen, len); // 2
            }
            map.put(sum, i+1); // 15, 6
        }
        return minLen == Integer.MAX_VALUE? 0: minLen; // 2
    }
}

// map
// 0, 0
// 2, 1
// 5, 2
// 6, 3
// 8, 4
// 12, 5
// 15, 6
