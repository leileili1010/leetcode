class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        // dfs
        int m = board.length;
        int n = board[0].length;
        char[] letters = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, letters, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] letters, int row, int col, int k) {
        // base case 1:
        if (board[row][col] != letters[k]) return false;
        
        // base case 2:
        if (k == letters.length-1) return true;

        // mark board[row][col] as visited
        board[row][col] = 0;

        // dfs
        for (int[] dir: DIRS) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length 
                && dfs(board, letters, x, y, k+1)) {
                return true;
            }
        }
        board[row][col] = letters[k]; 
        return false;
    }
}