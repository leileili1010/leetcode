class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = 0 - nums[i];
            int left = i + 1, right = N-1;

            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left++], nums[right--])));
                    while (left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return res;
    }
}