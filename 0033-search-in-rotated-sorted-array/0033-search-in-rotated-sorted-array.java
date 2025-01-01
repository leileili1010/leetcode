class Solution {
    public int search(int[] nums, int target) {
        // 1. find min index
        int minIdx = findMin(nums);

        // 2. identify range
        if (target < nums[minIdx] || (minIdx > 0 && target > nums[minIdx-1])) {
            return -1;
        }
        int n = nums.length;
        int start = (target <= nums[n-1])? minIdx: 0; 
        int end = start == minIdx? n: minIdx;

        // 3. find target using binary search
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return nums[start] < nums[end]? start: end;
    }
}