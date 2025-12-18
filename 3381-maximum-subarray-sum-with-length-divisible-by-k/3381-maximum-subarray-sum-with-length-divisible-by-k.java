class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minS = new long[k];
        Arrays.fill(minS, 0, k - 1, Long.MAX_VALUE / 2); // 防止下面减法溢出

        long ans = Long.MIN_VALUE;
        long s = 0;
        for (int j = 0; j < nums.length; j++) {
            s += nums[j];
            int i = j % k;
            ans = Math.max(ans, s - minS[i]);
            minS[i] = Math.min(minS[i], s);
        }
        return ans;
    }
}

