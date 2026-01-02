class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9]; // row i has num x
        boolean[][] colHas = new boolean[9][9]; // col j has num x
        boolean[][][] squareHas = new boolean[3][3][9]; // box [i][j] has num x

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int x  = c - '1';

                if (board[i][j] == '.') continue;

                if (rowHas[i][x] || colHas[j][x] || squareHas[i/3][j/3][x]) return false;
                rowHas[i][x] = colHas[j][x] = squareHas[i/3][j/3][x] = true;
            }
        }
        return true;
    }
}