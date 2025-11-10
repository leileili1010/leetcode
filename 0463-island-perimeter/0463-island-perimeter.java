class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    
                    for (int[] step: steps) {
                        int x = i + step[0];
                        int y = j + step[1];
                        if (isValid(x, y, grid)) res--;
                    }
                }
            }
        }
        return res;
    }    
                    
    private boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}