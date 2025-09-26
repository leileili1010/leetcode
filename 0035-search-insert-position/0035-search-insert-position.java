class Solution {
    public int searchInsert(int[] nums, int target) {
        // find the 1st number >= target, return index
        int n = nums.length;
        if (target > nums[n-1]) return n;
        int left = 0, right = n-1;

        while (left + 1 < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[left] >= target? left: right;
    }
}