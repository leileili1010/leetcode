class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, count>
        map.put(0, 1);
        int sum = 0, res = 0;

        for (int num: nums) {
            sum += num;
            if (map.containsKey(sum-goal)) {
                res += map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}