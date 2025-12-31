class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i <= m - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                if (isMagic(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        // 1️⃣ 中心必须是 5
        if (g[r + 1][c + 1] != 5) return false;

        // 2️⃣ 数字必须是 1~9 且不重复
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int x = g[i][j];
                if (x < 1 || x > 9 || seen[x]) return false;
                seen[x] = true;
            }
        }

        // 3️⃣ 只检查前两行
        for (int i = 0; i < 2; i++) {
            int sum = g[r + i][c] + g[r + i][c + 1] + g[r + i][c + 2];
            if (sum != 15) return false;
        }

        // 4️⃣ 只检查前两列
        for (int j = 0; j < 2; j++) {
            int sum = g[r][c + j] + g[r + 1][c + j] + g[r + 2][c + j];
            if (sum != 15) return false;
        }

        return true;
    }
}
