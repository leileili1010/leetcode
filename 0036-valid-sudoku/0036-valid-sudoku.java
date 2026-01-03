class Solution {
    public boolean isValidSudoku(char[][] board) {
        // board: 9*9, num ~[1, 9] or '.'
        // check:
            // row: 没有重复
            // col: 没有重复
            // square 3*3: 没有重复
        
        boolean[][] rowHas = new boolean[9][9]; // rowHas[i][x] 第i行有没有x这个数
        boolean[][] colHas = new boolean[9][9]; // colHas[j][x] 第j列有没有x这个数
        boolean[][][] squareHas = new boolean[3][3][9]; // sqaureHas[i][j]有没有x这个数

        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int x = c - '1'; // [1, 9] ==> [0, 8]

                if (rowHas[i][x] || colHas[j][x] || squareHas[i/3][j/3][x]) return false;

                rowHas[i][x] = true; 
                colHas[j][x] = true; 
                squareHas[i/3][j/3][x] = true;
            }
        }
        return true;
    }
}