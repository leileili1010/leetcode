class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // quick check to ensure we search on the shorter array
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        // logic to find median: 
            // if m+n is odd, median is the max left side number (most left)
                // so we want left side to have one more element than the right side
            // if m+n is even, median is average of (leftmost + rightmost)/2
                // so both sides have same number of elements
        int m = nums1.length;
        int n = nums2.length;
        int numberOfLeftElements = (m+n+1)/2;
        
        int left = 0, right = m;
        while (left <= right) {
            int partition1 = left + (right-left)/2; //partition for nums1, number of elements we need for leftside from nums1
            int partition2 = numberOfLeftElements - partition1; //partition for nums2, number of elements we need for leftside from nums2

            int maxLeftFromNums1 = partition1 == 0? Integer.MIN_VALUE: nums1[partition1-1];
            int maxLeftFromNums2 = partition2 == 0? Integer.MIN_VALUE: nums2[partition2-1];

            int minRightFromNums1 = partition1 == m? Integer.MAX_VALUE: nums1[partition1];
            int minRightFromNums2 = partition2 == n? Integer.MAX_VALUE: nums2[partition2];

            // implement binary search
            if (maxLeftFromNums1 <= minRightFromNums2 && maxLeftFromNums2 <= minRightFromNums1) { // valid
                if ((m+n) % 2 == 0) {
                    return (Math.max(maxLeftFromNums1,maxLeftFromNums2) + Math.min(minRightFromNums1, minRightFromNums2)) / 2.0;
                } else {
                    return Math.max(maxLeftFromNums1,maxLeftFromNums2);
                }
            } else if (maxLeftFromNums1 > minRightFromNums2) { // not valid
                right = partition1 - 1;
            } else { // not valid
                left = partition1 + 1;
            }
        }
        return 0.0;
    }
}