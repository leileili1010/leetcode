class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); //用于去重. e.g [1,1,3,4,6], 跳过第二个1
        dfs(nums, target, res, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, long target, List<List<Integer>> res, List<Integer> list, int start, int k) {
        //  退出条件： 已经有4个数且和为target
        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            if (nums[i] > target) break;

            list.add(nums[i]);
            dfs(nums, target-nums[i], res, list, i+1, k-1);
            list.remove(list.size()-1);
        }
    }
}