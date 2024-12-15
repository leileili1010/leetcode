class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }

        int pointer0 = -1;
        int pointer2 = nums.length;
        int idx = 0;

        while (idx < pointer2) {
            int cur = nums[idx];
            if (cur > 1) {
                swap(nums, idx--, --pointer2);    
            } else if (cur < 1) {
                swap(nums, idx--, ++pointer0);
            }
            idx++;
            if (idx == pointer0) {
                idx++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}