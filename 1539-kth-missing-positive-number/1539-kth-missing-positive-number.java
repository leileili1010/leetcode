class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;

        // 找到第一个 missing(i) >= k 的下标 left
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 此时 left 为第一个 missing(i) >= k 的位置；若不存在则 left == n
        return left + k;
    }
}
