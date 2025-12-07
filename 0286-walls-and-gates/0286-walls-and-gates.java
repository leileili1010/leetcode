class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int rows = rooms.length;
        int cols = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[] {i, j});
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            int distance = rooms[row][col];

            for (int[] dir: dirs) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) continue;

                if (rooms[newRow][newCol] == Integer.MAX_VALUE) {
                    rooms[newRow][newCol] = distance + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}