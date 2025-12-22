class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = r/3 + "," + c/3;
                if (!rows.computeIfAbsent(r, k -> new HashSet<>()).add(board[r][c])) return false;
                if (!cols.computeIfAbsent(c, k-> new HashSet<>()).add(board[r][c])) return false;
                if (!squares.computeIfAbsent(squareKey, k-> new HashSet<>()).add(board[r][c])) return false;
            }
        }
        
        return true; 
    }
}