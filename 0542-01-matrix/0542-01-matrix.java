class Solution {
    int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] matrix = new int[rows][cols];
       
       // Initialize the queue with all 0s and mark them as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
                
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for (int[] step: steps) {
                int row = step[0] + curRow;
                int col = step[1] + curCol;
                
                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    matrix[row][col] = matrix[curRow][curCol] + 1; 
                    visited[row][col] = true;
                    que.add(new int[]{row, col});
                }
            }
        }
        return matrix;
    }
}