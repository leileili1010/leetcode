class Solution {
    int n;
    int m;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        if (m * n < word.length()) return false;

        boolean[][] visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (findWord(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findWord(char[][] board, String word, int row, int col, int k, boolean[][] visited) {
        if (board[row][col] != word.charAt(k)) return false; 
        if (k == word.length()-1) return true;
        
        visited[row][col] = true; //只把和word匹配的标记true, 起点要走的四个方向不用标记true，因为有可能这次用不着，找下一个字符能用着

        for (int[] dir: dirs) { 
            int x = row + dir[0];
            int y = col + dir[1];
             if (0 <= x && x < board.length && 0 <= y && y < board[x].length && !visited[x][y] && findWord(board, word, x, y, k+1, visited)) {
                return true; // 搜到了！
            }
        }
        visited[row][col] = false; // very important step：表面起点不对，这条路走不通，只能回到主函数找下一个起点
        return false; // very important step
    }
}

