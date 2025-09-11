class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minSize = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minSize = Math.min(minSize, i-left+1);
                sum -= nums[left++];
            }
        }
        return minSize == Integer.MAX_VALUE? 0: minSize;
    }
}