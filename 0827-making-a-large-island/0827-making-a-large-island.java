class Solution {
    int rows, cols;
    private static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    public int largestIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int mark = 2; // island ids start from 2
        Map<Integer, Integer> areaMap = new HashMap<>();
        int maxArea = 0;

        // Step 1: BFS to color all islands and calculate area
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = bfsColor(grid, r, c, mark);
                    areaMap.put(mark, area);
                    maxArea = Math.max(maxArea, area);
                    mark++;
                }
            }
        }

        // Step 2: Try to flip every 0 and calculate possible max area
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighborIds = new HashSet<>();
                    int newArea = 1; // flip this 0 to 1

                    for (int[] d : DIRS) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                            int id = grid[nr][nc];
                            if (id > 1) {
                                neighborIds.add(id);
                            }
                        }
                    }

                    for (int id : neighborIds) {
                        newArea += areaMap.get(id);
                    }

                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }

        return maxArea;
    }

    // BFS: color the island and calculate area
    private int bfsColor(int[][] grid, int sr, int sc, int mark) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(encode(sr, sc));
        grid[sr][sc] = mark;

        int area = 0;

        while (!queue.isEmpty()) {
            int code = queue.poll();
            int r = code / cols;
            int c = code % cols;
            area++;

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = mark;
                    queue.offer(encode(nr, nc));
                }
            }
        }

        return area;
    }

    // Encode (r,c) to single int
    private int encode(int r, int c) {
        return r * cols + c;
    }
}
