class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        // grid：m * n, num ~ [1, 15]
        // magic sqaure: 
            // 3 * 3 matrix, num ~ [1, 9]
            // sum of every col, every row and every diagal must be equal
        // sum = 15
        // center = 5
        // interate every sqaure and check:
            // 1. center is 5
            // 2. 1~9 && deplicates
            // 2. row sum 
            // 3. col sum
           
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagic(grid, i, j)) res++;
            }
        }
        return res;
    }

    private boolean isMagic (int[][] grid, int r, int c) {
        // check center
        if (grid[r+1][c+1] != 5) return false;

        // check 1~9 && deuplicates
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int x = grid[i][j];
                if (x < 1 || x > 9 || seen[x]) return false;
                seen[x] = true;
            }
        }

        // check row sum
        for (int i = 0; i < 2; i++) {
            int sum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if (sum != 15) return false;
        }

        // check col sum
        for (int j = 0; j < 2; j++) {
            int sum = grid[r][c+j] + grid[r+1][c+j] + grid[r+2][c+j];
            if (sum != 15) return false;
        }

        return true;
    }

    
}