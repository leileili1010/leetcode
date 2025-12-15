class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int m = nums1.length;
        int n = nums2.length;
        int noOfLeftElements = (m + n + 1) / 2;
        int left = 0, right = m;

        while (left <= right) {
            int leftFromNums1 = left + (right-left)/2;
            int leftFromNums2 = noOfLeftElements - leftFromNums1;

            int maxLeftFromNums1 =  leftFromNums1 == 0? Integer.MIN_VALUE: nums1[leftFromNums1-1];
            int minRightFromNums1 = leftFromNums1 == m? Integer.MAX_VALUE: nums1[leftFromNums1];

            int maxLeftFromNums2 = leftFromNums2 == 0? Integer.MIN_VALUE: nums2[leftFromNums2-1];
            int minRightFromNums2 = leftFromNums2 == n? Integer.MAX_VALUE: nums2[leftFromNums2];

            if (maxLeftFromNums1 <= minRightFromNums2 && maxLeftFromNums2 <= minRightFromNums1) {
                if ((m+n) % 2 == 0) {
                    return (Math.max(maxLeftFromNums1, maxLeftFromNums2) + Math.min(minRightFromNums1, minRightFromNums2)) /2.0;
                } else {
                    return Math.max(maxLeftFromNums1, maxLeftFromNums2);
                } 
            } else if (maxLeftFromNums1 > minRightFromNums2) {
                right = leftFromNums1-1;
            } else {
                left = leftFromNums1 + 1;
            }
        }
        return 0.0;

    }
}