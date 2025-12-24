class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] w = word.toCharArray();
        
        // 1. 频次预检查 (面试官非常喜欢这个优化)
        int[] counts = new int[128];
        for (char[] row : board) {
            for (char c : row) counts[c]++;
        }
        for (char c : w) {
            if (--counts[c] < 0) return false;
        }

        // 2. 搜索方向优化 (可选，但建议口述)
        // 如果尾部字符在矩阵中更少，反转单词从尾部开始搜
        // ... (此处可根据时间决定是否实现)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, w, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (k == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }

        // 标记访问：利用位运算或特殊字符原地修改
        char temp = board[i][j];
        board[i][j] = 0; 

        // 递归四个方向
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                      dfs(board, word, i - 1, j, k + 1) ||
                      dfs(board, word, i, j + 1, k + 1) ||
                      dfs(board, word, i, j - 1, k + 1);

        // 回溯：恢复现场
        board[i][j] = temp;
        return res;
    }
}

