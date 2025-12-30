class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] exists = new boolean[n+1];
        int[] res = new int[2];

        for (int num: nums) {
            if (exists[num]) {
                res[0] = num;
            }
            exists[num] = true;
        }

        for (int i = 1; i < exists.length; i++) {
            if (!exists[i]) {
                res[1] = i;
                break;
            }
        }

        return res;
    }
}