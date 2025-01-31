class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;

        while (fast < n) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < n) {
            nums[slow] = 0;
            slow++;
        }
    }
}