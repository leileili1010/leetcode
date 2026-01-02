class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9]; // rowHas[i][x]: 第i行是否有x
        boolean[][] colHas = new boolean[9][9]; // colHas[j][x]: 第j列是否有x
        boolean[][][] squareHas = new boolean[3][3][9]; // square[i][j][x] square[i][j]是否有x

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int x = c - '1'; // [1, 9] ==> [0, 8]

                if (c == '.') continue;

                if (rowHas[i][x] || colHas[j][x] || squareHas[i/3][j/3][x]) return false;

                rowHas[i][x] = true;
                colHas[j][x] = true;
                squareHas[i/3][j/3][x] = true;
            }
        }
        return true;
    }
}