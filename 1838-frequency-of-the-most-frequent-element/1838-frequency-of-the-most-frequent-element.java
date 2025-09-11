class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long sum = 0;
        int left = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long need = (long)nums[i] * (i-left+1) - sum;

            while (need > k) {
                sum -= nums[left++];
                need = (long) nums[i] * (i-left+1) - sum;
            }
            
            count = Math.max(count, i-left+1);
        }
        return count;
    }
}