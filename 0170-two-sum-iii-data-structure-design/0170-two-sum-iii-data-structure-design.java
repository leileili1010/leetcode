class TwoSum {
    TreeMap<Integer,Integer> map;

    public TwoSum() {
        map = new TreeMap<>();    
    }
    
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0)+1);
    }
    
    public boolean find(int value) {
        for (int key: map.keySet()) {
            int target = value - key;

            if (target == key && map.get(target) >1) {
                return true;
            }

            if (target != key) {
                if (map.containsKey(target)) {
                    return true;
                }
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