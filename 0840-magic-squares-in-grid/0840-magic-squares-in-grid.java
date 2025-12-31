class Solution {
    public int numMagicSquaresInside(int[][] grid) {
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

    private boolean isMagic(int[][] grid, int r, int c) {
        // check center is 5
        if (grid[r+1][c+1] != 5) return false;

        // check none repeating
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int x = grid[i][j];
                if (seen[x]) return false;
                seen[x] = true;
            }
        }

        // check sumRow = 15;
        for (int i = 0; i < 2; i++) {
            int sum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
            if (sum != 15) return false;
        }

        // check sumCol = 15
        for (int j = 0; j < 2; j++) {
            int sum = grid[r][c+j] + grid[r+1][c+j] + grid[r+2][c+j];
            if (sum != 15) return false;
        }
        return true;
    }


}