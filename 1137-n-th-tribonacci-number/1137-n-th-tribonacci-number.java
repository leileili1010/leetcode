class Solution {
    private Map<Integer, Integer> dp = new HashMap<>(){{
            put(0, 0);
            put(1, 1);
            put(2, 1);
    }};

    public int tribonacci(int n) {
        return dfs(n);
    }

    public int dfs(int n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        int answer = dfs(n-1) + dfs(n-2) + dfs(n-3);
        dp.put(n, answer);
        return answer;
    }
}