class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        
        // state: dp[i] means the max sum ends at ith number
        int[] dp = new int[n];
        // initialization
        dp[0] = nums[0];
        
        // function
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            max = Math.max(dp[i], max);
        }

        // answer
        return max;
    }
}