class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort to skip duplicates easily
        // loop nums, target = 0 - nums[i]
            // if nums[i] == nums[i-1] skip
            // corner case, if the smallest number > 0 return res (empty list);
            // from [i+1, n-1] using twosum similar method to find the rest two numbers
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // corner case
        if (nums[0] > 0) return res;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int num1 = nums[i];
            int target = 0-num1;
            int left = i+1, right = n-1;

            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(num1, nums[left++], nums[right--])));
                    while (left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return res;
    }
}