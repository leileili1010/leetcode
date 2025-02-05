class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);// 排序才能去重
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, list, res);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}