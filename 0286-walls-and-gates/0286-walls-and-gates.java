class Solution {
    int rows;
    int cols;
    int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        rows = rooms.length;
        cols = rooms[0].length;
        Deque<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    que.offer(new int[]{i, j});
                }
            }
        }

        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0];
            int col = node[1];

            for (int[] step: steps) {
                int newRow = row + step[0];
                int newCol = col + step[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols 
                || rooms[newRow][newCol] <= rooms[row][col]+1) {
                    continue;
                }
                que.offer(new int[]{newRow, newCol});
                rooms[newRow][newCol] = rooms[row][col]+1;
            }
        }     
    }
}