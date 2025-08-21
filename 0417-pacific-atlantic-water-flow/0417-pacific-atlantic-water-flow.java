class Solution {
    int cols;
    int rows;
    int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            if (!pacific[i][0]) bfs(heights, i, 0, pacific);
            if (!atlantic[i][cols-1]) bfs(heights, i, cols-1, atlantic);
        }

        for (int j = 0; j < cols; j++) {
            if (!pacific[0][j]) bfs(heights, 0, j, pacific);
            if (!atlantic[rows-1][j]) bfs(heights, rows-1, j, atlantic);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;
    }

    private void bfs(int[][] heights, int i, int j, boolean[][] visited) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];
                if (isValid(newRow, newCol, visited) && heights[newRow][newCol] >= heights[row][col]) {
                    que.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
    } 

    private boolean isValid(int i, int j, boolean[][] visited) {
        return i >= 0 && i < rows && j >= 0 && j < cols && !visited[i][j];
    }
}