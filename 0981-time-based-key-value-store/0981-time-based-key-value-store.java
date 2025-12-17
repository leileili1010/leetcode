class Node {
    String val;
    int timestamp;

    Node(String val, int timestamp) {
        this.val = val;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    Map<String, List<Node>> map;

    public TimeMap() {
       // initializes the object of the data structure
       map = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        // Stores the key key with the value value at the given time timestamp
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Node> list = map.get(key);
        int left = 0, right = list.size()-1;
        String res = "";
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            Node t = list.get(mid);

            if (t.timestamp <= timestamp) {
                res = t.val;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */