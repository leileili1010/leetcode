class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        
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
            
            list.add(candidates[i]);
            sum -= candidates[i];
            dfs(candidates, list, sum, i, res);
            list.remove(list.size()-1);
            sum += candidates[i];
        }
    }
}