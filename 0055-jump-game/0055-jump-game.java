class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        // state, dp[i] means if we can reach dp[i] from dp[0]
        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}