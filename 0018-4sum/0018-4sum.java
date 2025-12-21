class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 用于去重. e.g [1,1,3,4,6], 跳过第二个1
        dfs(nums, target, res, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, long target, List<List<Integer>> res, List<Integer> list, int start, int k) {
        int n = nums.length;

        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // 去重
            
            if (n - i < k) return;
            if ((long)nums[i] * k > target) break;
            if ((long)nums[i] + (long)nums[n-1] * (k-1) < target) continue;


            list.add(nums[i]);
            dfs(nums, target-nums[i], res, list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}