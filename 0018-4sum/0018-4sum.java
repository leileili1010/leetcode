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
        if (k == 2) {
            twoSum(nums, res, list, start, target); 
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

    private void twoSum(int[] nums, List<List<Integer>> res, List<Integer> list, int start, int target) {
        int left = start, right = nums.length-1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
                while (left < right && nums[left] == nums[left-1]) left++;
                while (left < right && nums[right] == nums[right+1]) right--;
            }
        }
    }
}