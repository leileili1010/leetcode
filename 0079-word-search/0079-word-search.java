class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] letters = word.toCharArray();

        // optimization 1：
        int[] counts = new int[128];
        for (char[] row: board) {
            for (char c: row) counts[c]++;
        }

        for (char c: letters) {
            if (--counts[c] < 0) return false;
        }

        // optimization 2: 
        if (counts[letters[letters.length-1]] < counts[letters[0]]) {
            letters = new StringBuilder(word).reverse().toString().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, letters, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] letters, int row, int col, int k) {
        // 1. base case 1: check if current letter mattches letters[k]
        if (board[row][col] != letters[k]) return false;

        // 2. base case 2: we found it
        if (k == letters.length-1) return true;

        // 3. dfs
        // 3-1 mark the correct letter as visited to avoid visiting it again
        board[row][col] = 0; // board[i][j] = '/0', means null/showing nothing

        // 3-2 loop through 4 dirs
        for (int[] dir: DIRS) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length 
                && dfs(board, letters, x, y, k+1)) {
                return true; 
            }
        }
        
        board[row][col] = letters[k];
        return false;
    }
}