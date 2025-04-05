class Solution {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;

        int len = 1, max = 1;
        Arrays.sort(nums);

        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i-1]) continue;
            
            if (nums[i] == nums[i-1]+1) {
                len += 1;
                max = Math.max(len, max);
            } else {
                len = 1;
            }
        }
        return max;
    }
}