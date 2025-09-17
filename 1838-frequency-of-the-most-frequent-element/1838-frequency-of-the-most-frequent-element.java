class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, count = 0;
        long sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += (long)nums[i];

            while ((long)nums[i] * (i-left+1)-sum > k) {
                sum -= nums[left];
                left++;
            }

            count = Math.max(count, i-left+1);
        }
        return count;
    }
}