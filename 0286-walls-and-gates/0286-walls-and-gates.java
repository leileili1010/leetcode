class Solution {
    int rows;
    int cols;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        // loop through each cell in rooms to find door (0)
        // put each door in a queue
        // bfs: 
            // start bfs to update distance for each empty cell
            // compare the current distance to old one, only udpate when closer to door
        
        rows = rooms.length;
        cols = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();

        // 1. find all doors and place them in queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }

        // 2. bfs and udpate distance
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir: dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (isValid(newRow, newCol) && rooms[curr[0]][curr[1]]+1 < rooms[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol});
                    rooms[newRow][newCol] = rooms[curr[0]][curr[1]] + 1;
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}