

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int current = cost[i] + Math.min(dp1, dp2);
            dp2 = dp1;
            dp1 = current;
        }

        return Math.min(dp1, dp2);
    }
}