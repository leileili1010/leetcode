class Solution {
    int rows;
    int cols;
    int[][] steps = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        rows = rooms.length;
        cols = rooms[0].length;
        Deque<int[]> que = new ArrayDeque<>();

        // step 1: find out all gates
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                   que.offer(new int[] {i, j});
                }
            }
        }

        // step 2: 
        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0];
            int col = node[1];

            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];

                // no need to do anything;
                if (!isValidCell(newRow, newCol) || rooms[newRow][newCol] <= rooms[row][col] + 1) {
                    continue;
                }
                rooms[newRow][newCol] = rooms[row][col] + 1;
                que.offer(new int[] {newRow, newCol});
            }
        }
    }

    private boolean isValidCell(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}