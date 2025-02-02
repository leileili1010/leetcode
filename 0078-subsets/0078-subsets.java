class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        dfs(nums, new ArrayList<Integer>(), res, 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, int start) {
        if (start >= nums.length) return;
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, list, res, i+1);
            list.remove(list.size()-1);
        }
    }
}