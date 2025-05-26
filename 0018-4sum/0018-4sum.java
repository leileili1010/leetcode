class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, 4, (long)target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int k, long target, List<Integer> path, List<List<Integer>> res) {
        int n = nums.length;

        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (k == 0 || start >= n) return;

        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            // Optional pruning (only works when nums are sorted)
            // Too few elements left
            if (n - i < k) break;

            // Prune if minimum possible sum > target
            if ((long)nums[i] + (long)nums[n - 1] * (k - 1) < target) continue;

            // Prune if maximum possible sum < target
            if ((long)nums[i] * k > target) break;

            path.add(nums[i]);
            dfs(nums, i + 1, k - 1, target - nums[i], path, res);
            path.remove(path.size() - 1);
        }
    }
}
