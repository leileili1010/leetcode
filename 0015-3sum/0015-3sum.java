class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums to avoid duplicates
        // loop nums, [0, n-2), num, skip duplicates
        // left & right pointers, to find target = 0-num, here using binanry search
            // skip duplicates

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n-2; i++) {
            // corner case;
            if (nums[i] > 0) return res;
            
            // skip duplicates
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int target = 0 - nums[i];
            int left = i+1, right = n-1;
           
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                }
            } 
        }
        return res;
    }
}