class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = 1;

        for (int num: nums) {
            if (num > 0) {
                res[i] = num;
                i += 2;
            } else {
                res[j] = num;
                j += 2;
            }
        }
        return res;
    }
}