class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums2 = [5,7,10]
        // nums1 = [ \6, 12 ]
        // number of elements in smaller half = (m + n + 1)/2
            // num1 elements belongs to smaller half: do binary search on number of nums1 elements
            // nums2 elements belongs to smaller half = total left - nums1 element
        // binary search    
            // maxLeftFromNums1 < minRightFromNums1, vice versa
        // calculate median: total odd and total even, different ways
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int numberOfLeftElements = (m+n+1)/2;

        int left = 0, right = nums1.length; // nums1 is the shorter array
        while (left <= right) {
            int partition1 = left + (right-left)/2;
            int partition2 = numberOfLeftElements - partition1;

            int maxLeftFromNums1 = partition1 == 0? Integer.MIN_VALUE: nums1[partition1-1];
            int minRightFromNums1 = partition1 == m? Integer.MAX_VALUE: nums1[partition1];

            int maxLeftFromNums2 = partition2 == 0? Integer.MIN_VALUE: nums2[partition2-1];
            int minRightFromNums2 = partition2 == n? Integer.MAX_VALUE: nums2[partition2];

            if (maxLeftFromNums1 <= minRightFromNums2 && maxLeftFromNums2 <= minRightFromNums1) {
                int maxLeft = Math.max(maxLeftFromNums1, maxLeftFromNums2);
                int minRight = Math.min(minRightFromNums1, minRightFromNums2);

                if ((m + n) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return (double)maxLeft;
                }
            } else if (maxLeftFromNums1 > minRightFromNums2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        return 0.0;
    }
}