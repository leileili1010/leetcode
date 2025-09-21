class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i = 0, x = 1;
        while (i < arr.length && k > 0) {
            if (arr[i] == x) {
                i++;
            } else {
                k--;
                if (k == 0) return x;
            }
            x++;
        }
        // 数组已用完：继续往后数缺失的 k 个
        return x + k - 1;
    }
}
