class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        kSum(4, 0, target, nums, res, quad);
        return res;
    }

    // backtracking
    private void kSum(int k, int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        // based case
        if (k == 2) {
            twoSum(start, target, nums, res, quad);
            return;
        }
        
        for (int i = start; i < nums.length-k+1; i++) {
            // remove duplicate
            if (i > start && nums[i] == nums[i-1]) continue;
            if (nums.length - i < k) break;
            if ((long)nums[i] * k > target) break; // 也可以用return

            // Prune 3: if maximum possible sum < target
            if ((long)nums[i] + (long)nums[nums.length - 1] * (k - 1) < target) continue; //只能用contin

            quad.add(nums[i]);
            kSum(k-1, i+1, target-nums[i], nums, res, quad);
            quad.remove(quad.size()-1);
        }
    }

    // binary search + two pointers
    private void twoSum(int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int left = start, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
                while (left < right && nums[left] == nums[left-1]) left++;
            }
        }
    }
}