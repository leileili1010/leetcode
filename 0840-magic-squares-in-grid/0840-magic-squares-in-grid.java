class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }

                int mask = 0;
                int[] rSum = new int[3];
                int[] cSum = new int[3];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int x = grid[i + r][j + c];
                        mask |= 1 << x;
                        rSum[r] += x;
                        cSum[c] += x;
                    }
                }

                if (mask == (1 << 10) - 2 &&
                    rSum[0] == 15 && rSum[1] == 15 &&
                    cSum[0] == 15 && cSum[1] == 15) {
                    ans++;
                }
            }
        }

        return ans;
    }
}