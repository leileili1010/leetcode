class TrieNode {
    public Map<String, TrieNode> children;
    public int val;

    public TrieNode(int val) {
        children = new HashMap<>();
        this.val = val;
    }
}

class FileSystem {
    TrieNode root;

    public FileSystem() {
        root = new TrieNode(-1);    
    }
    
    public boolean createPath(String path, int value) {
        // if not exists, creat path
        // or return false if exits or parent path does not exist
        String[] words = path.split("/");
        int n = words.length;
        TrieNode node = root;

        for (int i = 1; i < n-1; i++) {
            String word = words[i];
            if (!node.children.containsKey(word)) return false;
            node = node.children.get(word);
        }

        String last = words[n-1];
        if (node.children.containsKey(last)) {
            return false;
        }
        node.children.put(last, new TrieNode(value));
        return true;
    }
    
    public int get(String path) {
        // return value 
        // return -1 if path does not exist
        String[] words = path.split("/");
        TrieNode node = root;

        for (int i = 1; i < words.length; i++) {
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