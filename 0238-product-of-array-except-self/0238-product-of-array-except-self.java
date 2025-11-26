class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            product *= nums[i-1];
            res[i] = product;
        }

        product = 1;
        for (int i = n-2; i >= 0; i--) {
            product *= nums[i+1];
            res[i] *= product;
        }

        return res;
    }
}