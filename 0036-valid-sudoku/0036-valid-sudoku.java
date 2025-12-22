class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use 3 maps
            // map<row, char>
            // map<col, char>
            // map<string, char>
        // loop through each cell, update maps
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                String squareKey = r/3 + "," + c/3;
                if (!rows.computeIfAbsent(r, k -> new HashSet<>()).add(ch)) return false;
                if (!cols.computeIfAbsent(c, k -> new HashSet<>()).add(ch)) return false;
                if (!squares.computeIfAbsent(squareKey, k -> new HashSet<>()).add(ch)) return false;
            }
        }
        return true;
    }
}