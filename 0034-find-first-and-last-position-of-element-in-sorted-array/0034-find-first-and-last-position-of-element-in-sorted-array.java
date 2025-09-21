class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while (start+1 < end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] >= target) {
                end = mid; // 继续往左找
            } else {
                start = mid;
            } 
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }


       private int findLast(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while (start+1 < end) {
            int mid = start + (end-start)/2;
            
            if (nums[mid] <= target) {
                start = mid; // 继续往右找
            } else {
                end = mid;
            } 
        }

        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }
}