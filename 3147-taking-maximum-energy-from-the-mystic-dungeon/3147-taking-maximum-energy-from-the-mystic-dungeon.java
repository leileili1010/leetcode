class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        // Use long in case sum becomes large (though each energy ≤ 1000 or ≥ −1000, but path length might be big)
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;

        // fill from end to front
        for (int i = n - 1; i >= 0; i--) {
            int take = energy[i];
            if (i + k < n) {
                take += dp[i + k];
            }
            dp[i] = take;
            ans = Math.max(ans, take);
        }

        return ans;
    }
}