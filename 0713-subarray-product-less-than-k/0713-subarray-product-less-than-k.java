class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int res = 0, left = 0;

        for (int i = 0; i < nums.length; i++) { // i = 3
            product *= nums[i]; // 10 * 6 = 60

            while (product >= k && left <= i) { // F
                product /= nums[left++]; // product = 10
            } // left = 1

            res += i - left + 1; // res = 2 + 1 = 3 + 2 = 5 + 3 = 8
        }
        return res;   
    }
}