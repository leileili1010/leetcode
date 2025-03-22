class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left + 1 < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // start, end

        if (nums[right] == target) return right;
        if (nums[left] == target) return left;
        return -1;
    }
}