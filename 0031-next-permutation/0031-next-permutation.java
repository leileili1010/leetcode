class Solution {
    public void nextPermutation(int[] nums) {
        // find the pivot: from right to left, find the first index where num[i] < num[i+1];
        // from right to left, find the first number that's greater than the pivot
        // swap i and n-1
        // reverse i to n-1

        int n = nums.length;
        int i = n-2;

        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        } 

        if (i >= 0) {
            int j = n-1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i+1);
    }

    private void reverse (int[] nums, int start) {
        int left = start, right = nums.length-1;

        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}