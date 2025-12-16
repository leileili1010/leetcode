class Solution {
    public int search(int[] nums, int target) {
        // distinct numbers
        // 1. binary search: find the pivot, the min value
        // 2. binary search: search target in a range
        
        int n = nums.length;
        int minIndex = findMinIndex(nums);
        int left, right;
        
        if (minIndex == 0) {
            left = 0;
            right = n-1;
        } else {
            if (target <= nums[n-1]) {
                left = minIndex;
                right = n-1;
            } else {
                left = 0;
                right = minIndex-1;
            }
        }

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int start = 0, end = nums.length-1;

        while (start + 1 < end) {
            int mid = start + (end-start)/2;

            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] < nums[end]? start: end;
    }
}