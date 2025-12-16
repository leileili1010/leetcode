class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        return totalSum % 2 == 0? nums.length - 1: 0;     
    }
}