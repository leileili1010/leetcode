class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < n-1; i++) {
            res[i+1] = res[i] * nums[i];
        }
        
        for (int i = n-1; i > 0; i--) {
            product *= nums[i];
            res[i-1] *= product;
        }
        return res;
    }
}