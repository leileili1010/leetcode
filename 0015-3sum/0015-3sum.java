class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // loop each nums[i] and skip duplicates
        // two pointers: left = i+1, right = n-1, find nums[i] + nums[left] + nums[right] = 0
            // left++ if < target or right-- if > target
            // found the correct comb, add list to res, alse skip duplicates for left and right
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i-1]) continue; // skip duplicates
            
            int target = 0 - nums[i];
            int left = i+1, right = n-1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return res;
    }   
        
}