class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dirs = {{1,-2},{-1,-2}, {2,-1}, {-2,-1}, {2,1}, {-2,1}, {1,2}, {-1,2}};
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[605][605];

        int[] start = {0, 0};        
        que.offer(start);
        visited[300][300] = true;
        int steps = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                int[] cell = que.poll();
                if (cell[0] == x && cell[1] == y) return steps;

                for (int[] dir: dirs) {
                    int[] next = {cell[0] + dir[0], cell[1] + dir[1]};
                    if (!visited[next[0]+302][next[1]+302]) {
                        que.add(next);
                        visited[next[0]+302][next[1]+302] = true;
                    }
                }
            }
            steps++;
        }
        
        return steps;
    }
}