class Solution {
    // 不想继续传参数就写在外面；
    int[] candidates;
    int target;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       this.candidates = candidates;
       this.target = target;
       List<List<Integer>> res = new ArrayList<>();
       
       Arrays.sort(candidates); // 1） 1）2）减少循环, 可加不可加
       dfs(res, new ArrayList<>(), 0 , 0);

       return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(list)); // return copy of the list not the original list as list constantly changes. As list is a referece type, what you put in res will also changes.
            return;
        }
        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target - sum) break; // 2） 1）2）可加不可加
            
            list.add(candidates[i]);
            dfs(res, list, sum + candidates[i], i);
            list.remove(list.size()-1);
        }
    }  
}