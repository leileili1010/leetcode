class Solution {
    private int rows;
    private int cols;

    public int shortestDistance(int[][] grid) {
        // count No.of buildings
        // loop through all buildings, and start bfs
            // level order traversal to go 4 directions, if valid cell, update distance and reach, put in queue and mark visited
        // go through each cell that is 0 and check if reach == no.of buildings and compared path lenght;
        
        rows = grid.length;
        cols = grid[0].length;  
        int[][] reach = new int[rows][cols];
        int[][] distance = new int[rows][cols];
        int totalBuildings = 0;

        // 1. count no.of buildings
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) totalBuildings++;
            }
        }  

        // 2. loop all buildings, bfs each building and update reach and distance for empty cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    bfs(i, j, grid, distance, reach);
                }
            }
        }

        // 3. find the valid cell
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    count = Math.min(count, distance[i][j]);
                }
            }
        }

        return count == Integer.MAX_VALUE? -1: count;
    }

    private void bfs(int row, int col, int[][] grid, int[][] distance, int[][] reach) {
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        que.offer(new int[]{row, col});
        visited[row][col] = true;

        int dist = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            dist++;

            for (int i = 0; i < n; i++) {
                int[] cur = que.poll();

                for (int[] dir: dirs) {
                    int newRow = cur[0] + dir[0];
                    int newCol = cur[1] + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && !visited[newRow][newCol]
                        && grid[newRow][newCol] == 0
                    ) {
                        distance[newRow][newCol] += dist;
                        reach[newRow][newCol]++;
                        visited[newRow][newCol] = true;
                        que.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
    }
}