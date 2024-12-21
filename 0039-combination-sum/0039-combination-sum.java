class Solution {
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       this.candidates = candidates;
       this.target = target;
       Arrays.sort(candidates);
       List<List<Integer>> res = new ArrayList<>();
       dfs(res, new ArrayList<>(), 0 , 0);

       return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res, list, sum + candidates[i], i);
            list.remove(list.size()-1);
        }
    }  
}