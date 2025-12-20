class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0;

        for (int num: nums) {
            if (num > 0) {
                res[idx] = num;
                idx += 2;
                if (idx >= n) break;
            }
        }

        idx = 1;
        for (int num: nums) {
            if (num < 0) {
                res[idx] = num;
                idx += 2;
                if (idx >= n) break;
            }
        }
        return res;
    }
}