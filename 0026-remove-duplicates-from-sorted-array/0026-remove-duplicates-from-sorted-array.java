class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;

        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            } else {
                fast++;
            }
        }
        return slow + 1;
    }
}