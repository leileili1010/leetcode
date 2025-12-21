class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 用于去重. e.g [1,1,3,4,6], 跳过第二个1
        dfs(nums, target, res, new ArrayList<>(), 0, 4);
        return res;
    }

    private void dfs(int[] nums, long target, List<List<Integer>> res, List<Integer> list, int start, int k) {
        int n = nums.length;

        if (k == 2) {
            twoSum(start, target, nums, res, list);
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

    private void twoSum(int start, long target, int[] nums, List<List<Integer>> res, List<Integer> quad) {
        int left = start, right = nums.length-1;
        while (left < right) {
            long sum = (long)nums[left] + nums[right];
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
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            }
        }
    }


}