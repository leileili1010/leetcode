class Solution {
    int[][] steps = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        Deque<int[]> que = new ArrayDeque<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) que.offer(new int[] {i, j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for (int[] step: steps) {
                int row = step[0] + curRow;
                int col = step[1] + curCol;
                
                if (row < 0 || row >= rows || col < 0 || col >= cols || mat[row][col] <= mat[curRow][curCol] + 1) {
                    continue;
                }

                que.add(new int[] {row, col});
                mat[row][col] = mat[curRow][curCol] + 1; 
            }
        }
        return mat;
    }
}