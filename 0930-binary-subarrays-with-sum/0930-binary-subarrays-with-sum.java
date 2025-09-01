class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>(); // <sum, count>
        map.put(0,1);
        int sum = 0, res = 0;

        for (int num: nums) {
            sum += num; // sum = 2 + 1 = 3
            if (map.containsKey(sum-goal)) { // sum-goal = 3 - 2 = 1
                res += map.get(sum-goal); // res = 2+2 = 4
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res; // 4
    }
}

// map
// 0, 1
// 1, 2
// 2, 2
// 3, 1
