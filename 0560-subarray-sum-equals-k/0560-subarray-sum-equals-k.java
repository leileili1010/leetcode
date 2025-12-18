class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <prefixSum, count>
        map.put(prefixSum, 1);

        for (int num: nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum-k)) {
                res += map.get(prefixSum-k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }

        return res;
    }
}