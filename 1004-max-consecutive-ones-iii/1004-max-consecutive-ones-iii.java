class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, res = 0, zeros = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            
            res = Math.max(res, i-left+1);
        }
        return res;
    }
}