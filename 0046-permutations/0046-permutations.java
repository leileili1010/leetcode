class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}