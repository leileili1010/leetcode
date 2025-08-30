class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] prefixSum = getPrefixSum(nums);
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> sum2Index = new HashMap<>();
        sum2Index.put(0,0);

        for (int i = 0; i < nums.length; i++) {
            if (sum2Index.containsKey(prefixSum[i+1]-k)) {
                int len = i+1-sum2Index.get(prefixSum[i+1]-k);
                maxLen = Math.max(maxLen, len);
            }
            if (!sum2Index.containsKey(prefixSum[i+1])) {
                sum2Index.put(prefixSum[i+1], i+1);
            }
        }
        return maxLen == Integer.MIN_VALUE? 0: maxLen;
    }

    private int[] getPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }
        return prefixSum;
    }
}