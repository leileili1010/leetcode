class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // int: [-2e9, 2e9]
        // long: [-9e18, 9e18]
        // prefixSum:
            // nums[i...j) => prefixSum[j] - prefixSum[i]
            // length = j-i
            // prefixSum[j] - prefixSum[i]，prefixSum[i] 最小 
        // j-i % k == 0, j % k = i % k

         // 1. 构建前缀和
            // nums = [-5,1,2,-3,4]
            // prefixSum = [0, -5, -4, -2, -5, -1]
         // 2. 构建一个minPrefixSum数组
         // 3. 遍历前缀和的数组，j
            // i = j % k = 1
        int n = nums.length;
        long[] prefixSum = new long[n+1];
        for (int i = 0; i < n; i++) prefixSum[i+1] = nums[i] + prefixSum[i];

        long[] minPrefixSum = new long[k];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE/2); // overflow

        long res = Long.MIN_VALUE;
        for (int j = 0; j < prefixSum.length; j++) { // -2e14- 4.5e18
            int i = j % k;
            res = Math.max(res, prefixSum[j] - minPrefixSum[i]);
            minPrefixSum[i] = Math.min(minPrefixSum[i], prefixSum[j]);
        }
        return res;
    }
}