class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // int: [-2e09, 2e9]
        // long: [-9e18, 9e18]
        // i, j, (j - i) % k, j % k = i % k
            // j % k = x, j = ak + x
            // i % k = x, i = bk + x
        // x / 3, 0, 1, 2,
        // x / 5, 0, 1,2,3,4
        // prefixSum 
            // nums[i...j) = prefixSum[j] - prefixSum[i]
            // j-i
            // prefixSum[j] - prefixSum[i]

        // 1. 构建prefixSum, n+1
        // 2. 构建minPrefixSum, k, 
        // 3.
            // 遍历前缀和， j = 5, k =2 5 % 2 = 1
                // i = j % k, 1, 3
                // 
        
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for (int i = 0; i < n; i++) prefixSum[i+1] = prefixSum[i] + nums[i];

        long[] minPrefixSum = new long[k];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE/2);

        long res = Long.MIN_VALUE;
        for (int j = 0; j < prefixSum.length; j++) {
            int i = j % k;
            res = Math.max(res, prefixSum[j] - minPrefixSum[i]);
            minPrefixSum[i] = Math.min(minPrefixSum[i], prefixSum[j]);
        }

        return res;
    }
}