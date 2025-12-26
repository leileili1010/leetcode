class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public String word;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
        word = null;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
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
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int idx) {
        if (idx == word.length()) {
            return node.isWord; // 可能会出现abc在字典中，但是ab不在，所以要return node.isWord
        }
        char letter = word.charAt(idx);
        
        // case 1: current letter is '.'
        if (letter == '.') {
            for (char child: node.children.keySet()) {
                if (dfs(node.children.get(child), word, idx+1)) {
                    return true;
                }
            }
            return false;
        }

        // case 2: current letter is not '.'
        if (node.children.containsKey(letter)) {
            if (dfs(node.children.get(letter), word, idx+1)) {
                return true;
            }
        }

        // cannot find the word, return false
        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */