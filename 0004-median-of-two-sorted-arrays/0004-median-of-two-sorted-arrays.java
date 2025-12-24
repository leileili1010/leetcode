class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // binary search
        // nums1 [  | 1, 9   ]
        // nums2 [ 4, 5, |  8  ]
        // [1, 5, 6, | 8, 9]

        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int numberOfLeftelements = (m + n + 1) / 2;

        int left = 0, right = m; // nums1里面有多少个数是属于左边的（小的那一半)
        while (left <= right) {
            int partition1 = left + (right - left)/2;
            int partition2 = numberOfLeftelements - partition1;

            int maxLeftFromNums1 = partition1 == 0? Integer.MIN_VALUE: nums1[partition1-1];
            int minRightFromNums1 = partition1 == m? Integer.MAX_VALUE: nums1[partition1];

            int maxLeftFromNums2 = partition2 == 0? Integer.MIN_VALUE: nums2[partition2-1];
            int minRightFromNums2 = partition2 == n? Integer.MAX_VALUE: nums2[partition2];

            if (maxLeftFromNums1 <= minRightFromNums2 && maxLeftFromNums2 <= minRightFromNums1) {
                // return ans
                int maxLeft = Math.max(maxLeftFromNums1, maxLeftFromNums2);
                int minRight = Math.min(minRightFromNums1, minRightFromNums2);

                if ((m + n) % 2 == 0) {
                    return (maxLeft + minRight) / 2.0;
                } else {
                    return maxLeft;
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