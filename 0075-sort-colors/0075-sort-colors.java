class Solution {
    public void sortColors(int[] nums) {
        int wall = partition(nums, -1, 1);
        partition(nums, wall, 2);
    }

    private int partition(int[] nums, int wall, int pivot) {
        int pointer = wall + 1, end = nums.length-1;

        while (pointer <= end) {
            if (nums[pointer] < pivot) {
                swap(++wall, pointer, nums);
            }
            pointer++;
        }
        return wall;
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}