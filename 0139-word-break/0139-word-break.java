class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 1. state: dp[i] means if s[0:i-1] - the word can be found in set
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        
        // 2. init: s[0:0] means empty string, true as Empty string is always a valid segmentation
        dp[0] = true;

        // 3. function:
        // We iterate through all possible segmentations s[j:i] and check:
            // If dp[j] is true (meaning s[0:j] can be formed).
            // If s[j:i] exists in the wordDict.
        // If both conditions are met, we mark dp[i] = true and break out of the loop.
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // break;
                }
            }
        }
        // 4. answer
        return dp[n];
    }
}

