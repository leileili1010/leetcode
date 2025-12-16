class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count = 0;

        for (int i = 0; i <= n; i++) { // i = 3
            if (i != n && nums[i] == 1) { // nums[i] = 1
                count++; // count = 1
            } else {
                max = Math.max(count, max); // max = 2
                count = 0; 
            }
        }
        return max;
    }
}