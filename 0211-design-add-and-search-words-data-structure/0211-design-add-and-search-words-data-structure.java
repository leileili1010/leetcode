class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int idx) {
        // base case
        if (idx == word.length()) return node.isWord;

        char c = word.charAt(idx);

        // case 1: current char is '.'
        if (c == '.') {
            for (TrieNode child: node.children) {
                if (child != null && dfs(child, word, idx+1)) return true;
            }
            return false;
        }

        // case 2: current char is not '.'
        TrieNode child = node.children[c-'a'];
        if (child != null && dfs(child, word, idx+1)) {
            return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */