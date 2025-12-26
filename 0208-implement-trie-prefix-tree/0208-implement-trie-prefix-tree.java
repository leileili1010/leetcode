class TrieNode {
    TrieNode[] children;
    String word;
    boolean isWord;

    TrieNode() {
        children = new TrieNode[26];
        word = null;
        isWord = false;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) {
                node.children[c] = new TrieNode();
            }
            node = node.children[c];
        }
        node.isWord = true;
        node.word = word;
    }
    
    public boolean search(String word) {
        return find(word) == 2;
    }
    
    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            c -= 'a';
            if (node.children[c] == null) return 0;
            node = node.children[c]; 
        }
        return node.isWord? 2: 1; // 2-match word, 1-match prefix
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */