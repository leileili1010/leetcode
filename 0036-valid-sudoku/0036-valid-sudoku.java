class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row 
        for (int row = 0; row < 9; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];
                if (cur == '.') continue;
                if (set.add(cur) && cur-'0' >=0 && cur-'0' <= 9) continue;
                else return false;
            }
        }

        // col
        for (int col = 0; col < 9; col++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char cur = board[row][col];
                if (cur == '.') continue;
                if (set.add(cur) && cur-'0' >=0 && cur-'0' <= 9) continue;
                else return false;
            }
        }

        // square
        for (int square = 0; square < 9; square++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    char cur = board[row][col];
                    if (cur == '.') continue;
                    if (set.add(cur) && cur-'0' >=0 && cur-'0' <= 9) continue;
                    else return false;
                }
            }
        }
        return true;
    }
}