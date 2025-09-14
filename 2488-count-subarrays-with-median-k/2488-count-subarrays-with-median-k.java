class Solution {
    public int countSubarrays(int[] nums, int k) {
        int idx = -1, N = nums.length;
        
        for (int i = 0; i < N; i++) {
            if (nums[i] == k) {
                idx = i;
                break;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        for (int i = idx-1; i >= 0; i--) {
            sum += nums[i] > k? 1: -1;
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        sum = 0;
        int res = 0;
        for (int i = idx; i < N; i++) {
            sum += nums[i] == k? 0: nums[i] > k? 1: -1;
            res += map.getOrDefault(0-sum, 0);
            res += map.getOrDefault(1-sum, 0);
        }
        return res;
    }
}