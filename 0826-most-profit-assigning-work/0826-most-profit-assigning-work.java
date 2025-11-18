class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // int[][] aray of [difficulty, profit]
        // sort by difficulty
        // sort worker by ability
        // loop through each worker
            // using a pointer, while (point < n && within the worker's ability), to find the maxProfit
            // acculate each worker's profit
        int n = profit.length;
        int[][] jobs = new int[n][2]; // [difficulty, profit]

        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }

        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);

        int res = 0, j = 0;
        int maxProfit = 0;
        for (int w: worker) {
            while (j < n && w >= jobs[j][0]) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            res += maxProfit;
        }

        return res;
    }
}