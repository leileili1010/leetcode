class Solution {
    int rows;
    int cols;
    int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        if (rows * cols < word.length()) return false;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    boolean foundWord = dfs(i, j, 1, board, word, visited);
                    visited[i][j] = false;
                    if (foundWord) return true;
                }
            }
        }  

        return false;
    }

    private boolean dfs(int row, int col, int nextIdx, char[][] board, String word, boolean[][] visited) {
        if (nextIdx >= word.length()) return true;
        
        for (int[] step: steps) {
            int newRow = row + step[0];
            int newCol = col + step[1];

            if (isValid(newRow, newCol, visited) && board[newRow][newCol] == word.charAt(nextIdx)) {
                visited[newRow][newCol] = true;
                if (dfs(newRow, newCol, nextIdx+1, board, word, visited)) return true;
                visited[newRow][newCol] = false;
            }
        }

        return false;
    }

    private boolean isValid(int row, int col, boolean[][] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col];
    }
}