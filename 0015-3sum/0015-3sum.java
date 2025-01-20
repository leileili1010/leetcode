class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i <= n-3; i++) {
            int target = 0 - nums[i];
            int left = i+1, right = n-1;
            if (i > 0 && nums[i] == nums[i-1]) continue;

            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left++], nums[right--])));
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }
                
            }    

        }

        return res;
    }
}