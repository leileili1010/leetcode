class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // subarray length > 2
        // subarray sum % k == 0
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // remainder to index
        int sum = 0;

        for (int i = 0; i < nums.length; i++) { // i = 2
            sum += nums[i]; // 29
            int remainder = ((sum % k) + k) % k; // 5
            if (map.containsKey(remainder) && i+1-map.get(remainder) >= 2) // T && T 
                return true;
            
            map.put(remainder, i+1);
        }
        return false;
    }
}

// map
// 0, 0 (i = 0)
// 5, 1 (i = 1)
// 1, 2 (i = 2)
