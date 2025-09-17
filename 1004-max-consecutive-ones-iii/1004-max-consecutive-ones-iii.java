class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, n = nums.length, res = 0, zeroCount = 0;

        for (int i = 0; i < n; i++) { // i = 5
            if (nums[i] == 0) zeroCount++; // zeroCount = 3
           
            while (zeroCount > k) { // T, 
                if (nums[left] == 0) zeroCount--; //zeroCount = 2
                left++; // left = 4
            }
            res = Math.max(res, i-left+1); // res = 5
        }
        return res;
    }
}