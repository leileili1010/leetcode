class Solution {
    public void nextPermutation(int[] nums) {
        // find the pivot
        int n = nums.length;
        int i = n-2;

        while (i >= 0 && nums[i] >= nums[i+1]) i--;

        // find the smallest to swap
        if (i >= 0) {
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]) j--;
            swap(nums, i, j); 

        }

        // reverse
        reverse(nums, i+1, n-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}