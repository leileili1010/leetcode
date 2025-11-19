class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        word = null;
        isWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode node = root;

        for (char c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = word;
        node.isWord = true;
        
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char letter = word.charAt(index);

        if (letter == '.') {
            for (char key: node.children.keySet()) {
                if (dfs(node.children.get(key), word, index+1)){
                    return true;
                }
            }
            return false;
        }

        if (node.children.containsKey(letter)) {
             if (dfs(node.children.get(letter), word, index+1)) {
                return true;
            }
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