class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 1, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int idx, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        visited[row][col] = true;

        for (int[] dir: DIRS) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(idx) && !visited[x][y]) {
               if (dfs(board, word, x, y, idx + 1, visited)) return true;
            }
        }

        visited[row][col] = false;
        return false;
    }
}