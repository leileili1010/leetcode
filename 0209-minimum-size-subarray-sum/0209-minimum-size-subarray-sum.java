class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, count = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) { // i = 4
            sum += nums[i]; // sum = 10

            while (sum >= target) {
                count = Math.min(count, i-left+1); // count = 3
                sum -= nums[left++]; // sum = 6, left = 3
            }
        }   
        return count == Integer.MAX_VALUE? 0: count;
    }
}