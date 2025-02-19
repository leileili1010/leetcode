class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            find3Sum(nums, i, res);
        }
        return res;
    }

    public void find3Sum(int[] nums, int i, List<List<Integer>> res) {
        int left = i+1, right = nums.length-1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while (right > left && nums[right] == nums[right + 1]) right--;
                while (right > left && nums[left] == nums[left - 1]) left++;
            }

        }
    }
}