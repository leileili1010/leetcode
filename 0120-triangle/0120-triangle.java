class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];

        // dp代表状态
        for (int i = 0; i < n; i++) {
            dp[i] = new int[i+1];
        }

        // 初始化： 终点
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                //方程：到哪去
                dp[i][j] = triangle.get(i).get(j)+ Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        // 答案： 起点
        return dp[0][0];
    }
}