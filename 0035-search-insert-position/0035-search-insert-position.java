class Solution {
    public int searchInsert(int[] nums, int target) {
        // 找到 >= target的最小值的index
        int n = nums.length;
        if (target > nums[n-1]) return n;
        int start = 0, end = nums.length-1;

        while (start + 1 < end) {
            int mid = start + (end - start)/2;

            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return nums[start] >= target? start: end;
    }
}