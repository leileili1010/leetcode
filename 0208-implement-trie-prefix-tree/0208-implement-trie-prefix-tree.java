class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    String word;

    TrieNode() {
        children = new HashMap<>();
        isWord = false;
        word = null;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for (char letter: word.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.isWord = true;
        node.word = word;
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for (char letter: word.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char letter: prefix.toCharArray()) {
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */