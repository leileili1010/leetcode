class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long maxSum = (long) n * (n + 1) / 2;
        if (Math.abs(target) > maxSum || (maxSum - target) % 2 != 0) {
            return new int[]{};
        }
        long negSum = (maxSum - target) / 2; // 计算出所有需要变成负数的数之和

        int[] ans = new int[n];
        int l = 0;
        int r = n - 1;
        // 从 1,2,...,n 中选一些数，元素和等于 negSum
        // 为了让负数部分的字典序尽量小，从大往小选
        for (int x = n; x > 0; x--) {
            if (negSum >= x) {
                negSum -= x; 
                ans[l++] = -x;
            } else {
                // 大的正数填在末尾
                ans[r--] = x;
            }
        }
        return ans;
    }
}