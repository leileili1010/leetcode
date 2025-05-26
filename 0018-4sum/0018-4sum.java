class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), target, 0, 4);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int start, int k) {
        int N = nums.length;
        // exit
        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        // k== 0 && target != 0 四个数加起来不等于 target直接return
        if (k == 0) return;

        for (int i = start; i < N; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            // prune 1
            if (N-i < k) return;

            // prune 2
            if ((long)nums[i] * k > target) return;

            // prune 3
            if ((long)nums[i] + (long)nums[N-1]*(k-1) < target) continue;

            list.add(nums[i]);
            dfs(nums, res, list, target-nums[i], i+1, k-1);
            list.remove(list.size()-1);
        } 
    }
}