class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                String squareKey = i/3 + "," + j/3;
                
                if (!rows.computeIfAbsent(i, k -> new HashSet<>()).add(board[i][j])) return false;
                if (!cols.computeIfAbsent(j, k -> new HashSet<>()).add(board[i][j])) return false;
                if (!square.computeIfAbsent(squareKey, k -> new HashSet<>()).add(board[i][j])) return false;
            }
        }
        return true;
    }
}