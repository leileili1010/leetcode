class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int left = 0, right = list.size()-1;

        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            Pair pair = list.get(mid);
            
            if (pair.timestamp <= timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // Always check right first because it's the higher candidate.
        if (list.get(right).timestamp <= timestamp) {
            return list.get(right).value;
        }
        if (list.get(left).timestamp <= timestamp) {
            return list.get(left).value;
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */