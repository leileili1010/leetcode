class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // 1. 构建前缀和
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for (int i = 0; i < n; i++) prefixSum[i+1] = nums[i] + prefixSum[i];

        // 2. 前缀和 % k 分组
        long[] minPrefixSum = new long[k+1];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE/2);

        // 3. 遍历前缀和，计算最大subarray sum，更新最小前缀和
        long res = Long.MIN_VALUE;
        for (int j = 0; j < prefixSum.length; j++) {
            int i = j % k;
            res = Math.max(res, prefixSum[j] - minPrefixSum[i]);
            minPrefixSum[i] = Math.min(minPrefixSum[i], prefixSum[j]);
        }
        return res;
    }
}