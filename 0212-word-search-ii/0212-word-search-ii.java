class Solution {
    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;  // 当 word != null 时，这个节点代表一个完整单词
    }

    private TrieNode root = new TrieNode();
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        // 1. 构建 Trie
        for (String w : words) {
            insert(w);
        }

        int m = board.length, n = board[0].length;

        // 2. 从每个 cell 开始 DFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }

        return res;
    }

    // 插入到 Trie
    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.word = word; // 用 word 标记终点
    }

    // DFS 搜索
    private void dfs(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];

        // 字母已访问过 or 路径不在 Trie 中
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        // 找到一个完整单词
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // 防止重复加入
        }

        // 标记此字符已访问
        board[i][j] = '#';

        int m = board.length, n = board[0].length;
        // 向四个方向搜
        if (i > 0) dfs(board, i - 1, j, node);
        if (j > 0) dfs(board, i, j - 1, node);
        if (i < m - 1) dfs(board, i + 1, j, node);
        if (j < n - 1) dfs(board, i, j + 1, node);

        // 回溯
        board[i][j] = c;

        // 可选优化：如果 node 没有子节点了，可以把它裁掉（剪枝）
        // 这样能加速后续搜索，但不写也能 AC
    }
}
