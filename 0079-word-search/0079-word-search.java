class Solution {
    int n;
    int m;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        if (m * n < word.length()) return false;

        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0) && findWord(board, word, i, j, 1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findWord(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {
        if (idx == word.length()) return true;
        visited[row][col] = true;

        for (int[] dir: dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (isVaild(x, y) && !visited[x][y] && board[x][y] == word.charAt(idx)) {
                if (findWord(board, word, x, y, idx+1, visited)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    private boolean isVaild(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m; 
    }

   
}