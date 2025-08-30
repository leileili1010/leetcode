class Solution {
    public int subarraySum(int[] nums, int k) {
        // sum to count
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(sum, 1);

        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum-k)) res += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1); 
        }
        return res;
    }
}