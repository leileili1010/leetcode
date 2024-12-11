import java.util.HashMap;

class TwoSum {

    private HashMap<Integer, Integer> nums;

    public TwoSum() {
        nums = new HashMap<>();
    }
    
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0) + 1); // O(1)
    }
    
    public boolean find(int value) {
        for (int key : nums.keySet()) {
            int desired = value - key;
            if (nums.containsKey(desired)) {
                if (desired == key && nums.get(desired) > 1) {
                    return true;
                } else if (desired != key) {
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