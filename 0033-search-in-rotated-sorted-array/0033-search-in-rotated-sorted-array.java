class Solution {
    public int search(int[] nums, int target) {
        int min = findMin(nums);

        if (target < nums[min] || min > 0 && target > nums[min-1]) return -1;

        int n = nums.length;
        int left = 0, right = n-1;
        if (min != 0) {
            if (target >= nums[min]) {
                left = min;
            } else {
                left = 0;
                right = min-1;
            }
        }

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;

        while (left + 1 < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[right] < nums[left]? right: left;
    } 
}