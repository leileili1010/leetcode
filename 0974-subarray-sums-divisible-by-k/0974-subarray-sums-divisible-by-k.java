class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1); // prefixSum能被k整除的count
        int sum = 0, res = 0;

        for (int num: nums) {
            sum += num;
            int remainder = ((sum % k) + k) % k;

            if (remainderCount.containsKey(remainder)) {
                res += remainderCount.get(remainder);
            }
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0)+1);
        }
        return res;
    }
}