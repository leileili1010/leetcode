class Solution {
    public int searchInsert(int[] nums, int target) {
        // find the 1st number >= target, return index
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return left;
    }
}