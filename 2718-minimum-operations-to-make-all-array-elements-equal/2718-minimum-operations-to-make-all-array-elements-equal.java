class Solution {
        public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        List<Long> ans = new ArrayList<>();
        for (int q : queries) {
            int idx = binarySearch(nums, q); // There are idx numbers in nums less than q.
            ans.add(1L * q * idx - prefixSum[idx] + prefixSum[n] - prefixSum[idx] - 1L * (n - idx) * q);
        }
        return ans;
    }
    private int binarySearch(int[] nums, int key) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > nums[mid]) {
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }
}