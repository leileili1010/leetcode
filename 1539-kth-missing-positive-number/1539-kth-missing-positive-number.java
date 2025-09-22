class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0, end = n - 1;

        // 如果到最后一个元素都没达到k，直接返回
        if (arr[n-1] - n < k) return n + k;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing >= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        int missingAtStart = arr[start] - (start + 1);
        if (missingAtStart >= k) {
            return start + k;
        } else {
            return end + k;
        }
    }
}
