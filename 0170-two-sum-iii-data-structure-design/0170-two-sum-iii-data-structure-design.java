class TwoSum {
    Map<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();   
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
        
    }
    
    public boolean find(int value) {
        for (int key: map.keySet()) {
            int target = value - key;
            int count = key == target? 2: 1;
            if (map.containsKey(target) && map.get(key) >= count) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */