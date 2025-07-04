class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, (long)target, res, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, long target, List<List<Integer>>res, List<Integer> list, int start, int k) {
        int N = nums.length;

        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(list));
            return; 
        }

        for (int i = start; i < N; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;

            // pruning 1
            if (N - i < k) break;

            // pruning 2
            if ((long)nums[i] * k > target) break;

            // pruning 3
            if ((long)nums[i] + (long)nums[N-1] * (k-1) < target) continue; 

            list.add(nums[i]);
            dfs(nums, target-nums[i], res, list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}