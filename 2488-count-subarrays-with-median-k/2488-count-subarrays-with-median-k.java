class Solution {
    public int countSubarrays(int[] nums, int k) {
        int idx = -1; // idx = 3

        // 1. 找到index of k
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        // 2. left prefixSum from idx-1 to 0 position
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int sum = 0;
        map.put(sum, 1);
        for (int i = 0; i < idx; i++) {
            sum += nums[i] > k? 1: -1;
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        // 3. match with right prefixsum, together should be 0 or 1
        sum = 0;
        int res = 0;
        for (int i = idx; i < nums.length; i++) {
            sum += nums[i] == k? 0: nums[i] > k? 1: -1;
            res += map.getOrDefault(1-sum, 0);
            res += map.getOrDefault(0-sum, 0);
        } 

        return res;
    }
}

// map
// 0, 1,
// -1, 1
// -2, 1
// -3, 1