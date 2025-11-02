class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int numberOfLeft = (m+n+1) /2;

        int left = 0, right = m;
        while (left <= right) {
            int partition1 = left + (right - left)/2;
            int partition2 = numberOfLeft - partition1;

            int maxLeftFromNums1 = partition1 == 0? Integer.MIN_VALUE: nums1[partition1-1];
            int minRightFromNums1 = partition1 == m? Integer.MAX_VALUE: nums1[partition1];

            int maxLeftFromNums2 = partition2 == 0? Integer.MIN_VALUE: nums2[partition2-1];
            int minRightFromNums2 = partition2 == n? Integer.MAX_VALUE: nums2[partition2];

            if (maxLeftFromNums1 <= minRightFromNums2 && maxLeftFromNums2 <= minRightFromNums1) {
                if (( m + n) % 2 ==  0) {
                    return (Math.max(maxLeftFromNums1, maxLeftFromNums2) + Math.min(minRightFromNums1, minRightFromNums2)) /2.0;
                } else {
                    return Math.max(maxLeftFromNums1, maxLeftFromNums2);
                }
            } else if (maxLeftFromNums1 > minRightFromNums2) {
                right = partition1-1;
            } else {
                left = partition1+1;
            }
        }
        return 0.0;

    }
}