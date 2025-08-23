class Solution {
    int rows;
    int cols;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        rows = grid.length;
        cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return -1;
        
        int destination = (rows-1) * cols + (cols-1);
        HashMap<Integer, Integer> distance = new HashMap<>();
        Deque<Integer> que = new ArrayDeque<>();
        que.offer(0);
        distance.put(0, 1);


        while (!que.isEmpty()) {
            int cur = que.poll();
            int row = cur / cols;
            int col = cur % cols;
            int[][] steps = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
            
            for (int[] step: steps ) {
               int newRow = row + step[0];
               int newCol = col + step[1];

               if (isValid(grid, newRow, newCol, distance)) {
                    int node = newRow * cols + newCol;
                    que.offer(node);
                    distance.put(node, distance.get(cur) + 1);
                    if (node == destination) {
                        return distance.get(node);
                    } 
               }
            }

        }
        return distance.containsKey(destination)? distance.get(destination): -1;
    }

    private boolean isValid(int[][] grid, int x, int y, HashMap<Integer, Integer> distance) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) return false;
        if (grid[x][y] == 1) return false;
        if (distance.containsKey(x * cols + y)) return false;
        return true;

    }
}