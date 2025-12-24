class Solution {
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] w = word.toCharArray();
        
        // 1. 统计每一个字母在board中出现的频率
        int[] counts = new int[128];
        for (char[] row : board) {
            for (char c : row) counts[c]++;
        }

        // 2. 如果某一个字母在word中出现的频率大于board中的总个数，return false
        for (char c : w) {
            if (--counts[c] < 0) return false;
        }

        // 3. 搜索方向优化 (可选，但建议口述)
        // 如果尾部字符在矩阵中更少，反转单词从尾部开始搜
        // ... (此处可根据时间决定是否实现)
        if (counts[w[w.length-1]] < counts[w[0]]) {
            w = new StringBuilder(word).reverse().toString().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, w, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;

        board[i][j] = 0; // 标记访问

        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1];

            if (0 <= x && x < board.length && 
                0 <= y && y < board[0].length &&
                dfs(board, word, x, y, k + 1))   // <-- 正确递归
            {
                return true;
            }
        }

        board[i][j] = word[k]; // 回溯恢复
        return false;
    }
}

