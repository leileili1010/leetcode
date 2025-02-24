class Solution {
    public int superEggDrop(int k, int n) {
        // dp[k] represents the maximum number of floors that can be checked with k eggs in 'moves' moves.
        int[] dp = new int[k + 1];
        int moves = 0;

        // Continue until we can check at least N floors.
        while (dp[k] < n) {
            moves++;
            // Update the dp array in reverse order to avoid overwriting values.
            for (int i = k; i > 0; i--) {
                dp[i] = dp[i - 1] + dp[i] + 1;
            }
        }
        
        return moves;
    }
}