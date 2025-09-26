class Solution {
    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        if (target < nums[minIdx] || (minIdx > 0 && target > nums[minIdx-1])) {
            return -1;
        }
        int n = nums.length;
        int start, end;
        if (minIdx == 0) {
            start = 0;
            end = n-1;
        } else {
            if (target <= nums[n-1]) {
                start = minIdx;
                end = n-1;
            } else {
                start = 0;
                end = minIdx-1;
            }
        }

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    private int findMinIdx(int[] nums) {
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