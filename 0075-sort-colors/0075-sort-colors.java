class Solution {
    public void sortColors(int[] nums) {
        int start = partition(nums, 0, 0);
        partition(nums, start, 1);
    }

    private int partition(int[] nums, int start, int k) {
        int n = nums.length, left = start, right = n-1;
        while (left <= right) {
            while (left <= right && nums[left] <= k) {
                left++;
            }

            while (left <= right && nums[right] > k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
                left++;
            }
        }
        return left;
    }
}