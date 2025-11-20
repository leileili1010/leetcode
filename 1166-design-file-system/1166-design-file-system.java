class FileSystem {
    Map<String, Integer> map; 

    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        // Coner case
        if (path.isEmpty() || path.equals("/")) return false;

        // check if already exists
        if (map.containsKey(path)) return false;

        // check if parent exists
        int lastSlashIndex = path.lastIndexOf("/");
        String parent = path.substring(0, lastSlashIndex);

        if (parent.length() > 1 && !map.containsKey(parent)) return false;
       
       // Valid case
        map.put(path, value);
        return true;
    }
    
    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */