class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordSet, memo);
    }

    private List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);

        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (String word : wordSet) {
            if (s.startsWith(word)) {
                String suffix = s.substring(word.length());
                List<String> suffixWays = dfs(suffix, wordSet, memo);
                for (String seg : suffixWays) {
                    if (seg.isEmpty()) res.add(word);
                    else res.add(word + " " + seg);
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
