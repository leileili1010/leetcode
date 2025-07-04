class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
         kSum(4, 0, target, nums, res, new ArrayList<>());
        return res;
    }

    private void kSum(int k, int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int N = nums.length;

        if (k == 2) {
            twoSum(start, target, nums, res, quad);
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

            quad.add(nums[i]);
            kSum(k-1, i+1, target-nums[i], nums, res, quad);
            quad.remove(quad.size()-1);
        }
    }


    private void twoSum(int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int left = start, right = nums.length-1;
        while (left < right) {
            long sum = nums[right] + nums[left];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> temp = new ArrayList<>(quad);
                temp.add(nums[left++]);
                temp.add(nums[right--]);
                res.add(temp);
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
            }

        }
    }
}