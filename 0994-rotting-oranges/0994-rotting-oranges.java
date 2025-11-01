class Solution {
    int rows;
    int cols;

    public int orangesRotting(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> que = new ArrayDeque<>();
        int freshCount = 0;
        int time = 0;

        // 1. find all rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) que.offer(new int[] {i, j});
                if (grid[i][j] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;

        // 2.
        while (!que.isEmpty()) {
            int n  = que.size();
            time++;
            for (int i = 0; i < n; i++) {
                int[] node = que.poll();
                int row = node[0];
                int col = node[1];
                
                for (int[] step: steps) {
                  int newRow = row + step[0];
                  int newCol = col + step[1];
                  if (isValidCell(newRow, newCol) && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    que.offer(new int[] {newRow, newCol});
                    freshCount--;
                  }
                }
            }
        }
        return freshCount == 0? time-1: -1;
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}