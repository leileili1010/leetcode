class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];

        int index = 0;
        for (int i = 0; i < 2*n; i++) {
            if (index < n) {
                res[i] = nums[index++];
                if (index >= n) index = 0;
            }
        }
        return res;
    }
}