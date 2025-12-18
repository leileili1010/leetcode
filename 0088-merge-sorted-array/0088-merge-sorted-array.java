class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1, idx2 = n-1;

        for (int i = m+n-1; i >= 0; i--) { // i = 4
            if (idx2 < 0) break; 

            if (idx1 >= 0 && nums1[idx1] >= nums2[idx2]) {
                nums1[i] = nums1[idx1--];
            } else {
                nums1[i] = nums2[idx2--];
            }
        }
    }
}