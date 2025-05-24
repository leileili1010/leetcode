class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, new ArrayList<>(), target, 0, res);
        return res;        
    }

    private void dfs(int[] candidates, List<Integer> list, int target, int start, List<List<Integer>> res) {
        // recursion exit
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            target -= candidates[i];
            list.add(candidates[i]);
            dfs(candidates, list, target, i, res);
            list.remove(list.size()-1);
            target += candidates[i];
        }
    }
}