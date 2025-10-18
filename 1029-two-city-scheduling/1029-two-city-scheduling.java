class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int[][] diff = new int[n][2];
        int count  = 0;

        for (int i = 0; i < n; i++) {
            int[] cost = costs[i];
            diff[i][0] = cost[1] - cost[0];
            diff[i][1] = i;
        }

        Arrays.sort(diff, (a,b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                count += costs[diff[i][1]][1];
            } else {
                 count += costs[diff[i][1]][0];
            }
        }

        return count;
    }
}