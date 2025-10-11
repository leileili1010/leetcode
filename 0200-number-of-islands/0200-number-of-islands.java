class Solution {
    public int numIslands(char[][] grid) {
       // 0. 判断grid
       if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
       
        // 1. 定义数据
        HashSet<Integer> visited = new HashSet<>();

        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited.contains(i * m + j) && grid[i][j] == '1') {
                    count += 1;
                    bfs(grid, i, j, visited);
                }
            }
        } 

        return count;       
    }

    private void bfs(char[][] grid, int i, int j, HashSet<Integer> visited) {
        Deque<Integer> que = new ArrayDeque<>();
        int m = grid[0].length;
        que.offer(i * m + j);
        visited.add(i * m + j);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!que.isEmpty()) {
            int cur = que.poll();
            int x = cur / m;
            int y = cur % m;

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (isValid(grid, newX, newY, visited)) {
                    que.offer(newX * m + newY);
                    visited.add(newX * m + newY);
                }
            }
        }
    }
    
    private boolean isValid(char[][] grid, int x, int y, HashSet<Integer> visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;
        if (visited.contains(x * grid[0].length + y)) return false;
        if (grid[x][y] != '1') return false;
        return true; 
    }
}