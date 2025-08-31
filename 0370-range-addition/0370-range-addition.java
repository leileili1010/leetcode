class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length]; // 差分数组，初始全 0

        // 1) 处理所有区间更新：O(k)
        for (int[] op : updates) {
            int l = op[0], r = op[1], val = op[2];
            diff[l] += val;
            if (r + 1 < length) diff[r + 1] -= val;
        }

        // 2) 前缀和还原最终数组：O(n)
        int[] res = new int[length];
        int run = 0;
        for (int i = 0; i < length; i++) {
            run += diff[i];
            res[i] = run;
        }
        return res;
    }
}