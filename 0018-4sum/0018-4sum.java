class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // to remove duplicates
        backtracking(nums, res, target, new ArrayList<>(), 0, 4);
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, int target, List<Integer> list, int start, int k) {
        int n = nums.length;
        
        // base case
        if (k == 0) {
            if (target == 0) res.add(new ArrayList<>(list)); 
            return;
        }

        for (int i = start; i < n; i++) {
            if (i > start && nums[i] == nums[i-1]) continue; // remove duplicates
           
            // pruning
            if (n - i < k) return;
            if ((long)nums[i] * k > target) return;
            if ((long)nums[i] + (long)nums[n-1] * (k-1) < target) continue;

            list.add(nums[i]);
            backtracking(nums, res, target-nums[i], list, i+1, k-1); // k means we still need k numbers
            list.remove(list.size()-1);
        }
    }
}