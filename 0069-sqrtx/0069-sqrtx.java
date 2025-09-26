class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 0, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long product = (long) mid * mid;  // ✅ 用 long 防止溢出

            if (product == x) return mid;
            if (product < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;  // ✅ 最后 right 落在 floor(sqrt(x))
    }
}