class Solution {
    public int search(int[] nums, int target) {
        // Binary search to find min of nums
        // Binary search to find target
        int n = nums.length;
        int minIndex = findMin(nums);

        int left = 0, right = n-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            int realMid = (mid + minIndex) % n;

            if (nums[realMid] < target) {
                left = mid + 1;
            } else if (nums[realMid] > target) {
                right = mid -1;
            } else {
                return realMid;
            }
        }

        return -1;
    }

    private int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left + 1 < right) {
            int mid = left + (right-left)/2;
            
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return nums[left] < nums[right]? left: right;
    }
}