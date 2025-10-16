class Solution {
    int rows;
    int cols;
    int[][] steps = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        if (rows * cols < word.length()) return false;
        boolean[][] visited = new boolean[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && findWord(i, j, board, visited, 1, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(int row, int col, char[][] board, boolean[][] visited, int nextIndex, String word) {
        if (nextIndex == word.length()) return true;
        visited[row][col] = true;

        for (int[] step: steps) {
            int x = row + step[0];
            int y = col + step[1];

            if (isValidCell(x, y, visited) && board[x][y] == word.charAt(nextIndex)) {
               if (findWord(x, y, board, visited, nextIndex+1, word)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private boolean isValidCell(int row, int col, boolean[][] visited) {
        return row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col];
    }
}