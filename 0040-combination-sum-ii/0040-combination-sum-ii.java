class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            // skip duplicate in one loop
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;

            list.add(candidates[i]);
            dfs(candidates, target-candidates[i], list, res, i+1);
            list.remove(list.size()-1);
        }
    }
}