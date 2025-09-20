class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, res = 0, ones = 0;

        for (int i = 0; i < nums.length; i++) { // i = 3
            int num = nums[i]; // num = 0
            if (num == 0) {
                zeros++;
            } else {
                ones++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            res = Math.max(res, i-left+1-zeros); // res = 2
        }
        return ones == 0? 0: ones == nums.length? res-1: res;
    }
}