class Solution {
    int rows;
    int cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int largestIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int mark = 1;
        int maxArea = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    mark++;
                    int area = bfs(i, j, grid, mark);
                    map.put(mark, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> ids = new HashSet<>();
                    int area = 1;

                    for (int[] dir: dirs) {
                        int newRow = dir[0] + i;
                        int newCol = dir[1] + j;

                        if (isValid(newRow, newCol) && grid[newRow][newCol] > 1) {
                            ids.add(grid[newRow][newCol]);
                        }
                    }

                    for (int num: ids) {
                        area += map.get(num);
                    }
                    
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int bfs(int row, int col, int[][] grid, int mark) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});
        grid[row][col] = mark;
        int count = 0;

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            count++;

            for (int[] dir: dirs) {
                int newRow = dir[0] + curr[0];
                int newCol = dir[1] + curr[1];

                if (isValid(newRow, newCol) && grid[newRow][newCol] == 1) {
                    que.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = mark;
                }
            }
        }

        return count;
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}