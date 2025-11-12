class Solution {
    int rows, cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        rows = rooms.length;
        cols = rooms[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) { // gate
                    bfs(i, j, rooms);
                }
            }
        }
    }

    private void bfs(int row, int col, int[][] rooms) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{row, col});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x0 = cur[0], y0 = cur[1];

            for (int[] dir : dirs) {
                int x = x0 + dir[0];
                int y = y0 + dir[1];

                if (isValid(x, y, rooms) && rooms[x][y] > rooms[x0][y0] + 1) {
                    rooms[x][y] = rooms[x0][y0] + 1;
                    que.offer(new int[]{x, y});  
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] rooms) {
        return x >= 0 && x < rows && y >= 0 && y < cols && rooms[x][y] != -1;
    }
}
