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
        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int start = jobs[i][0];
            int curProfit = jobs[i][2];
            int j = bfs(jobs, i, start);
            int compatible = j >= 0? dp[j]: 0;
            dp[i] = Math.max(dp[i - 1], curProfit + compatible);
        }

        return dp[n-1];
    }

    private int bfs(int[][] jobs, int right, int target) {
        int left = 0;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left-1;
    }
}