class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
    
        // 1. state: dp[i] means the total energy you’d get if you start at index i.
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        // fill from end to front
        for (int i = n - 1; i >= 0; i--) {
            
            if (i + k < n) {
                dp[i] = energy[i] + dp[i + k];
            } else {
                dp[i] = energy[i];
            }
            
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}