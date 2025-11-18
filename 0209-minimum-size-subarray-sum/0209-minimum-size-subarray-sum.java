class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        // target = 7
        for (int i = 0; i < n; i++) { // i = 4
            sum += nums[i]; // sum = 10

            while (sum >= target) { // left = 2
                minLen = Math.min(minLen, i-left+1); // minLen = 3 
                sum -= nums[left]; // sum = 6
                left++; // left = 3
            }
        }

        return minLen == Integer.MAX_VALUE? 0: minLen;
    }
}