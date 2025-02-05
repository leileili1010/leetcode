class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
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
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}