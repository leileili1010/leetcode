class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0, 0);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum-k)) {
                int len = i + 1 - map.get(sum-k);
                maxLen = Math.max(maxLen, len);
            } 
            if (!map.containsKey(sum)) {
                map.put(sum, i+1);
            }
        }

        return maxLen == Integer.MIN_VALUE? 0: maxLen;
    }
}