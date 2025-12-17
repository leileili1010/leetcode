class Solution {
    private static final int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0, res = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = grid[i][j];
                if (num == 1) fresh++;
                else if (num == 2) queue.offer(new int[]{i, j});
            }
        }

        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
             time++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir: dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                        if (fresh == 0) return time;
                    }
                }
            }
           
        }
        return fresh == 0? time: -1;
        
    }
}