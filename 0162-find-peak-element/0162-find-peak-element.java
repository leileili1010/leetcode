class Solution {
    public int findPeakElement(int[] nums) {
        // nums = [1,2,1,3,5,6,4]
        
        int n = nums.length; // n = 7
        int start = 0, end = n-1; // end = 6

        while (start + 1 < end) { // 4 + 1 < 6
            int mid = start + (end-start)/2; // mid = 5

            if (nums[mid] < nums[mid-1]) {
                end = mid; // end = 6
            } else {
                start = mid; // start = 5
            }
        }
        return nums[end] > nums[start]? end: start;
    }
}