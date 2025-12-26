class Solution {
    // 1. TrieNode 结构优化
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
        int count = 0; // 核心：记录该节点下还有多少个单词
    }

    private void insert(TrieNode root, String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
            cur.count++; // 路径上每个节点的计数都增加
        }
        cur.word = word;
    }

    private List<String> res = new ArrayList<>();
    private int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) insert(root, w);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }
        return res;
    }

    private int dfs(char[][] board, int row, int col, TrieNode parent) {
        char c = board[row][col];
        int idx = c - 'a';
        TrieNode cur = parent.children[idx];

        // 1. 基础检查：不存在前缀或该路径下的单词已全部找完
        if (cur == null || cur.count <= 0) return 0;

        int foundCount = 0; // 本次 DFS 找到的新单词数量

        // 2. 找到单词
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null; // 标记为空防止重复
            foundCount++;
            // 注意：这里不要 return，因为当前单词可能是另一个长单词的前缀
        }

        // 3. 继续向下 DFS
        board[row][col] = '#'; // 标记访问
        for (int[] d : DIRS) {
            int x = row + d[0], y = col + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] != '#') {
                foundCount += dfs(board, x, y, cur);
            }
        }
        board[row][col] = c; // 回溯

        // 4. 关键：自底向上剪枝
        // 如果子树中已经贡献了 foundCount 个单词，从当前节点的计数中扣除
        cur.count -= foundCount;
        return foundCount;
    }
}