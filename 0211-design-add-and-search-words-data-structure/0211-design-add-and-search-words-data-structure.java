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
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            c -= 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
       return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int idx) {
        if (node == null) return false;

        if (idx == word.length()) return node.isWord;

        char c = word.charAt(idx);

        // case 1: current char is '.'
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (dfs(child, word, idx + 1)) {
                    return true;
                }
            }
            return false;
        }

        // case 2: current char is a letter
        return dfs(node.children[c - 'a'], word, idx + 1);
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */