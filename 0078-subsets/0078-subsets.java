class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path)); // Add the current subset

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);                     // Choose
            backtrack(nums, i + 1, path, res);     // Explore
            path.remove(path.size() - 1);          // Un-choose (backtrack)
        }
    }
}