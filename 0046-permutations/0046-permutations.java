class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> set) {
        // recursion exit
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, res, list, set);
            set.remove(nums[i]);
            list.remove(list.size()-1);
        }
    }
}