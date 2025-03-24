class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[right], nums[left]);
    }
}