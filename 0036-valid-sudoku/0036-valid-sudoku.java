class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows
        for (int i = 0; i < 9; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (!seen.add(board[i][j])) return false;
                }             
            }
        }

        // cols
        for (int j = 0; j < 9; j++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (Character.isDigit(board[i][j])) {
                    if (!seen.add(board[i][j])) return false;
                }             
            }
        }

        // square
        for (int square = 0; square < 9; square++) {
             Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square/3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (Character.isDigit(board[row][col])) {
                    if (!seen.add(board[row][col])) return false;
                }
                }
            }
        }

        return true;
    }
}