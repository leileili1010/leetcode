class Solution {
    public boolean canJump(int[] nums) {
       if (nums == null || nums.length == 0) {
            return false;
        }

        // state, dp[i] means if we can arrive at index i
        boolean[] dp = new boolean[nums.length];
        dp[0] = true; // becuase we can by default stand at index 0

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
               if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
               }
            }
        }
        return dp[nums.length-1];
    }
}

