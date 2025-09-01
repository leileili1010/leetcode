class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0) return 0;  // no subarray can have negative sum

        int left = 0, sum = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // shrink window until sum <= k
            while (sum > k) {
                sum -= nums[left++];
            }

            // now sum <= k, so all subarrays ending at `right` are valid
            res += (right - left + 1);
        }
        return res;
    }
}