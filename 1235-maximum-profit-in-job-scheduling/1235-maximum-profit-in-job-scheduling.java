class Solution {
    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job (int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = job;
        }

        Arrays.sort(jobs, (a,b) -> (a.endTime - b.endTime));

        int[] dp = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            int k = binarySearch(jobs, i-1, jobs[i-1].startTime);
            dp[i] = Math.max(dp[i-1], jobs[i-1].profit + dp[k]);
        }

        return dp[n];
    }

    private int binarySearch(Job[] jobs, int right, int target) {
        int left = 0;

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (jobs[mid].endTime > target) {
                right = mid-1;
            } else {
                left = mid+1;
            } 
        } 
        
        return left;
    }
}