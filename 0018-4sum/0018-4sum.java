class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), target, 0, 4);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, long target, int start, int k) {
        int N = nums.length;

        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < N; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            if (N-i < k) return;
            if ((long)nums[i] + (long)nums[N-1] * (k-1) < target) continue;
            if ((long)nums[i] * k > target) return;

            list.add(nums[i]);
            dfs(nums, res, list, target-nums[i], i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}