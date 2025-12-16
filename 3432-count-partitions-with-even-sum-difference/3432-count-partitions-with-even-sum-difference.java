class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int sum1 = 0, sum2 = 0;
        int res = 0;

        for (int i = 0; i < nums.length-1; i++) {
            sum1 += nums[i];
            sum2 = totalSum - sum1;
            if ((sum1-sum2) % 2 == 0) res++;
        }
        return res;       
    }
}