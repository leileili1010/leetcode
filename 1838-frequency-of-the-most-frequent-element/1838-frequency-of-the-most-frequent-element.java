class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 1 sort
        Arrays.sort(nums);

        // sliding window
        long sum = 0; 
        int res = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while ((long)nums[i] * (i-left+1) - sum > k) {
                sum -= nums[left++];
            }

            res = Math.max(res, i-left+1);
        }
        return res;
    }
}