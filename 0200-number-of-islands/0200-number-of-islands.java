class Solution {
    int rows;
    int cols;
    int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        rows = grid.length; 
        cols = grid[0].length;
        HashSet<String> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cur = grid[i][j];
                if (cur == '1' && !visited.contains(i+"_"+j)) {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
    
        return count;
    }

    private void bfs(int row, int col, HashSet<String> visited, char[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        visited.add(row+"_"+col);

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int[] step: steps) {
                int newRow = curRow + step[0];
                int newCol = curCol + step[1];

                if (isValidCell(newRow, newCol) && grid[newRow][newCol] == '1' && !visited.contains(newRow+"_"+newCol)) {
                    que.offer(new int[]{newRow, newCol});
                    visited.add(newRow+"_"+newCol);
                }
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}