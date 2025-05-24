class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        
        Arrays.sort(candidates);
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
            list.add(candidates[i]);
            dfs(candidates, list, target-candidates[i], i, res);
            list.remove(list.size()-1);
        }
    }
}