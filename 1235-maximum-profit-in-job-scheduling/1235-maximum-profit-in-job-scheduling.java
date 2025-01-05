class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // step 1: 构造jobs 并按照endTime 来sort
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a,b) -> (a[1] - b[1]));

        // step2: dp
        // state: dp[i] = max profit considering the first i jobs
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int start = jobs[i-1][0];
            int curProfit = jobs[i-1][2];
            int compatible = -1;
            for (int j = i - 2; j >= 0; j--) {
                if (jobs[j][1] <= start) {
                    compatible = dp[j+1];
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1], curProfit +(compatible == -1? 0: compatible));
        }

        return dp[n];
    }
}