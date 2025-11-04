class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int product = 1;
        int res = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];

            while (product >= k && left <= i) {
                product /= nums[left];
                left++;
            }

            res += i-left+1;
        }
        return res;
    }
}