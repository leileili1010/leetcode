class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    // count number of subarrays with at most k oddNumbers (0, 1, .. k-1, k);
    private int atMost(int[] nums, int k) {
        int left = 0, oddCount = 0, res = 0;

        for (int i = 0; i < nums.length; i++) {
            oddCount += nums[i] % 2;

            while (oddCount > k) {
                oddCount -= nums[left] % 2;
                left++;
            }

            res += i-left+1;
        }

        return res;
    }
}