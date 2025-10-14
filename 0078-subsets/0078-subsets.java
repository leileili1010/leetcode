class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));
        if (index == nums.length) return;
        
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i+1);
            list.remove(list.size()-1);
        }
    }
}