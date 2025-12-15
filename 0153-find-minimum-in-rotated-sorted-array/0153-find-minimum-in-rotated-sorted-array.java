class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;

        while (start + 1 < end) {
            int mid = start + (end-start)/2;

            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

       return Math.min(nums[start], nums[end]);
    }
}