class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num: nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int w = sum/2;
        int[][] dp = new int[n+1][w+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = Math.max(
                        dp[i-1][j],
                        dp[i-1][j-nums[i-1]] + nums[i-1]
                    );
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][w] == w;
    }
}