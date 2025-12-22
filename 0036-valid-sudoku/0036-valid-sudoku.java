class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHas = new boolean[9][9]; // rowHas[i][x] 表示 i 行是否有数字 x
        boolean[][] colHas = new boolean[9][9]; // colHas[j][x] 表示 j 列是否有数字 x
        boolean[][][] subBoxHas = new boolean[3][3][9]; // subBoxHas[i'][j'][x] 表示 (i',j') 宫是否有数字 x

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char b = board[i][j];
                if (b == '.') {
                    continue;
                }
                int x = b - '1'; // 字符 '1'~'9' 转成数字 0~8
                if (rowHas[i][x] || colHas[j][x] || subBoxHas[i / 3][j / 3][x]) { // 重复遇到数字 x
                    return false;
                }
                // 标记行、列、宫包含数字 x
                rowHas[i][x] = colHas[j][x] = subBoxHas[i / 3][j / 3][x] = true;
            }
        }

        return true;
    }
}


