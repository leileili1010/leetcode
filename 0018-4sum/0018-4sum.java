class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, target, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, long target, List<Integer> list, int start, int k) {
        if (k == 0) {
           if (target == 0) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
          

            list.add(nums[i]);
            dfs(nums, res, target-nums[i], list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}