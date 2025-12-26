// ========== Trie Node ==========
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null; // 若非 null，表示这里是一个完整单词的结尾
}

// ========== Trie ==========
class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.word = word;   // 标记完成一个单词
    }
}

// ========== Solution ==========
class Solution {
    private static final int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // 1. 构建 Trie
        Trie trie = new Trie();
        for (String w : words) trie.insert(w);

        int m = board.length, n = board[0].length;

        // 2. 遍历所有起点 DFS（类似 exist() 的扫描方式）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie.root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {
        char c = board[row][col];

        // base case 1: 已访问过或没有这个前缀
        if (c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        // base case 2: 找到完整单词
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // 删除以防重复加入
        }

        // mark visited
        board[row][col] = '#';

        // 四方向 DFS（风格与 exist() 完全一致）
        for (int[] d : DIRS) {
            int x = row + d[0];
            int y = col + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                dfs(board, x, y, node);
            }
        }

        // 回溯
        board[row][col] = c;
    }
}
