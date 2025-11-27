class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j <9; j++) {
                if (!isValid(i, j, board, set)) return false;
            }
        }

        // cols
        for (int j = 0; j < 9; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                 if (!isValid(i, j, board, set)) return false;
            }
        }

        // square
        for (int square = 0; square < 9; square++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i; // 很好的方法来move to 下一个square
                    int col = (square % 3) * 3 + j;
                    if (!isValid(row, col, board, set)) return false;
                }
            }
        }
        

        return true;
    }

    private boolean isValid(int row, int col, char[][] board, Set<Integer> set) {
        if (board[row][col] == '.') return true;

        int num = board[row][col] - '0';
        return num > 0 && num < 10 && set.add(num);
    }
}