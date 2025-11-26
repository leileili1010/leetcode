class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
       int wall = 0, end = n-1;

       for (int i = 0; i < n; i++) {
            if (nums[i] < 1 && i > wall) {
                swap(nums, i--, wall++);
            } else if (nums[i] > 1 && i < end) {
                swap(nums, i--, end--);
            }
       }

    }

     private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}