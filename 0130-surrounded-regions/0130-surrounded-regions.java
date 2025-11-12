class Solution {
    int rows;
    int cols;
    int[][] steps = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; 
    
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][cols-1] == 'O') bfs(board, i, cols-1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') bfs(board, 0, j);
            if (board[rows-1][j] == 'O') bfs(board, rows-1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        Deque<int[]> que = new ArrayDeque<>();
        board[i][j] = 'T';
        que.offer(new int[] {i, j});
        
        while (!que.isEmpty()) {
            int[] node = que.poll();
            int row = node[0]; 
            int col = node[1];

            for (int[] step: steps) {
                int newRow = step[0] + row;
                int newCol = step[1] + col;

                if (isValidCell(newRow,  newCol, board)){
                    board[newRow][newCol] = 'T';
                    que.offer(new int[] {newRow, newCol});
                }
            } 
        }

    }

    private boolean isValidCell(int i, int j, char[][] board) {
        return i >= 0 && i < rows && j > 0 && j < cols && board[i][j] == 'O';  
    }
}