class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res; 
            if (i > 0 && nums[i] == nums[i-1]) continue; // remove duplicates

            int target = 0 - nums[i];
            int left = i+1, right = nums.length-1;
            
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++; 
                    while (left < nums.length && nums[left] == nums[left-1]) left++;
                    right--;
                }
            }
        }

        return res;
    }
}