class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length; // n = 6
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) { // i = 4
            sum += nums[i]; // sum = 10

            while (sum >= target) {
                res = Math.min(res, i-left+1); // res = 3
                sum -= nums[left++]; // sum = 7, left =3
            }
        }

        return res == Integer.MAX_VALUE? 0: res;
    }
}

// nums = [2,3,1,2,4,3]
// index  [0,1,2,3,4,5] 