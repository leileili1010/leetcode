class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        for (String str: wordDict) {
            maxLen = Math.max(str.length(), maxLen);
        }

        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();

        // state: dp[i] means s[0, i) has valid break?
        boolean[] dp = new boolean[n+1];

        // init: s[0, 0), empty string default to have a valid break
        dp[0] = true; 

        // function 
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j >= Math.max(i-maxLen, 0); j--) {
                if (dict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}