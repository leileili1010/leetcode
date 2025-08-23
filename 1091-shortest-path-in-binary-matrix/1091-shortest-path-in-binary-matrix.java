class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 0. edge cases 
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;

        // 1. define data structure
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int count = 1;

        // 2. init
        que.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!que.isEmpty()) {
            int m = que.size();

            for (int i = 0; i < m; i++) {
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == n-1 && y == n-1) return count; 

                for (int[] step: steps) {
                    int newX = x + step[0];
                    int newY = y + step[1];

                    if (newX >= 0 && newX < n && newY >=0 && newY < n 
                        && !visited[newX][newY] 
                        && grid[newX][newY] == 0) {
                        
                        que.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
            count+=1;
        }
        return -1;
    }
}