class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0, max = 0, count = 0;

        for (int i = 0; i < n; i++) {
            count += nums[i];

            while (i - left + 1 - count > k) {
                count -= nums[left] == 1? 1: 0;
                left++;
            } 

            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}