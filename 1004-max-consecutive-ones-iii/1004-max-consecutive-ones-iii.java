class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) { // i = 9
            if (nums[i] == 0) k--; // k = 0

            while (k < 0 && left <= i) {
                if (nums[left] == 0) k++; // k = 0
                left++; // left = 4
            }
            max = Math.max(max, i-left+1); // max = 6
        }
        return max;
    }
}