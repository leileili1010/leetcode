class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int wall = partition(nums, -1, 1);
        partition(nums, wall, 2);
    }

    public int partition(int[] nums, int wall, int pivot) {
        int pointer = wall+1;
        int end = nums.length-1;

        while (pointer <= end) {
            if (nums[pointer] < pivot) {
                swap(nums, ++wall, pointer);
            } 
            pointer++;
        }

        return wall;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}