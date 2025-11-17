class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        
        // 1. find the pivot, from right to left, the first decreasing number
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        
        // 2. find the smallest number > pivot, from n-1 to pivot+1 index
        if (i >= 0) {
            int j = n-1;

            while (j > i && nums[j] <= nums[i]) {
                j--;
            }

            // 3. swap pivot and the number we found
            swap(nums, i, j);
        }

        // 4. reverse the partial digits order right to the pivot index
        reverse(nums, i+1, n-1);
    }

    private void reverse (int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}