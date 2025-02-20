class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!isValidCol(board,i)) return false;
        }

        int row = 0, col = 0;
        while (row < 9) {
            if (!isValidGrid(board, row, col)) return false;
            col += 3;
            if (col == 9) {
                col = 0;
                row += 3;
            }
        }

        return true;

        
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            char ch = board[row][i];
            
            if (Character.isDigit(ch)) {
                if (ch-'0' > 9 || ch-'0' < 1) return false;
                if (!set.add(ch)) return false;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            char ch = board[i][col];
            
            if (Character.isDigit(ch)) {
                if (ch-'0' > 9 || ch-'0' < 1) return false;
                if (!set.add(ch)) return false;
            }
        }
        return true;
    }

    private boolean isValidGrid(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    if (ch-'0' > 9 || ch-'0' < 1) return false;
                    if (!set.add(ch)) return false;
                }
            }
              
        }
        
        return true;
    }

}