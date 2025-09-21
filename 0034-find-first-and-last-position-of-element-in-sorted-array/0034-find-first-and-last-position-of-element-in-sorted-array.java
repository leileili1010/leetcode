class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length-1, res = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] < target) {
                start = mid+1;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                res = mid;
                end = mid-1;
            }
        }

        return res;
    }


    private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length-1, res = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] < target) {
                start = mid+1;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                res = mid;
                start = mid+1;
            }
        }

        return res;

    }
}