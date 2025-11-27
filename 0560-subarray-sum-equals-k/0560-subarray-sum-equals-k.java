class Solution {
    public int subarraySum(int[] nums, int k) {
        // count => 
        // subarray sum = k => prefixSum
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, count>
        int sum = 0, res = 0;
        map.put(sum, 1);

        for (int num: nums) {
            sum += num; // 1 + 1 = 2
            if (map.containsKey(sum-k)) { // 2-2 = 0
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}

// 1, 1
// 