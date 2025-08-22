class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;                 // 0 -> 0, 1 -> 1
        int left = 1, right = x / 2;         // sqrt(x) ≤ x/2 for x ≥ 2
        int ans = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {            // mid*mid <= x (overflow-safe)
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;                           // floor(sqrt(x))
    }
}