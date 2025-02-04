class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        if (start >= nums.length) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}