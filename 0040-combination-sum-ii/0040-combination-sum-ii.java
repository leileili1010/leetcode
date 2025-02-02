class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(candidates);
        dfs(candidates, new ArrayList<Integer>(), target, 0, res);
        return res;
    }

    private void dfs(int[] candidates, List<Integer> list, int sum, int start, List<List<Integer>> res) {
        if (sum == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (sum < 0) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > sum) break;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            list.add(candidates[i]);
            sum -= candidates[i];
            dfs(candidates, list, sum, i+1, res);
            list.remove(list.size()-1);
            sum += candidates[i];
        }
    } 
}