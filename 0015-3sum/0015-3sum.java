class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n-2; i++) {
            // 不可能有valid answer, return
            if (nums[i] > 0) return res;

            if (i > 0 && nums[i] == nums[i-1]) continue; // remove duplicate starter

            int left = i+1, right = n-1, target = 0 - nums[i];

            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }  
        }
        return res;        
    }
}