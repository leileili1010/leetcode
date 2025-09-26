class Solution {
    public int search(int[] nums, int target) {
        // 1. find index of the min element
        int minIdx = findMinIndex(nums);

        // 2. edge cases
        if (target < nums[minIdx] || minIdx > 0 && target > nums[minIdx-1]) return -1;

        // 3. confirm search range
        int n = nums.length;
        int left = 0, right = n-1; // normal when minIdx == 0

        if (target > nums[right]) {
            right = minIdx-1;
        } else  {
            left = minIdx;
        }

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left + 1 < right) {
            int mid = left + (right-left) /2;

            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] > nums[right]? right: left;
    }

}