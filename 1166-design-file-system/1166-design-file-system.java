class TrieNode {
    public Map<String, TrieNode> children;
    public int val;

    public TrieNode(int val) {
        this.val = val;
        children = new HashMap<>();
    }
}

class FileSystem {
    TrieNode root;

    public FileSystem() {
        root = new TrieNode(-1);
    }
    
    public boolean createPath(String path, int value) {
        // corner case
        if (path.isEmpty() || path.equals("/")) return false;

        // check if parents exist
        TrieNode node = root;
        String[] words = path.split("/"); // ["", "leetcode", "problems"]
        int n = words.length;

        for (int i = 1; i < n-1; i++) { // only check parents
            String word = words[i];
            if (!node.children.containsKey(word)) return false;
            node = node.children.get(word);
        }

        // check if path exists
        String last = words[n-1];
        if (node.children.containsKey(last)) return false;

        // create path
        node.children.put(last, new TrieNode(value));
        return true;
    }
    
    public int get(String path) {
        // corner case
        if (path.isEmpty() || path.equals("/")) return -1;

        TrieNode node = root;
        String[] words = path.split("/"); // ["", "leetcode", "problems"]
        int n = words.length;

        for (int i = 1; i < n; i++) {
            String word = words[i];
            if (!node.children.containsKey(word)) return -1;
            node = node.children.get(word);
        }

        return node.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */