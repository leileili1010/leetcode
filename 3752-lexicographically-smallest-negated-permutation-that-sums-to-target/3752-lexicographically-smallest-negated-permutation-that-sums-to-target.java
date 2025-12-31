class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long mx = (long) n * (n + 1) / 2;
        if (Math.abs(target) > mx || (mx - target) % 2 != 0) {
            return new int[]{};
        }
        long negS = (mx - target) / 2; // 取负号的元素（的绝对值）之和

        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        // 从 1,2,...,n 中选一些数，元素和等于 negS
        // 为了让负数部分的字典序尽量小，从大往小选
        for (int x = n; x > 0; x--) {
            if (negS >= x) {
                negS -= x;
                ans[l++] = -x;
            } else {
                // 大的正数填在末尾
                ans[r--] = x;
            }
        }
        return ans;
    }
}