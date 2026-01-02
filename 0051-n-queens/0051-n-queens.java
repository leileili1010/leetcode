class Solution {
    private boolean[] col, posDiag, negDiag;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        posDiag = new boolean[2 * n];
        negDiag = new boolean[2 * n];
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, res, board);
        return res;

    }

    private void backtrack(int r, int n, List<List<String>> res, char[][] board) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (char[] row: board) {
                list.add(new String(row));
            }
            res.add(list);
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r+c] || negDiag[r-c+n]) continue;

            col[c] = true;
            posDiag[r+c] = true;
            negDiag[r-c+n] = true;
            board[r][c] = 'Q';

            backtrack(r+1, n, res, board);

            col[c] = false;
            posDiag[r+c] = false;
            negDiag[r-c+n] = false;
            board[r][c] = '.';
        }
    }
        
}