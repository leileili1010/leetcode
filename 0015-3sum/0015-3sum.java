class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue; //只能是continue，如果是i++，那么target也需要更新
            }
            findTwoSum(nums, i, res);
        }
        return res;
    }

    public void findTwoSum(int[] nums, int i, List<List<Integer>> res) {
        int target = -nums[i];
        int left = i+1, right = nums.length-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left++], nums[right--])));
                // 去重，只有找到target的时候才需要去重
                while (left < right && nums[left] == nums[left-1]) {
                    left++; // 可以移动左边也可以移动右边
                }
            }
        }
    }
}