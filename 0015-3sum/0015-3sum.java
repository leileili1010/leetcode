class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int a = nums[i];
            if (i > 0 && a == nums[i-1]) continue;
            int target = 0-a;

            int left = i+1, right = N-1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (b + c < target) {
                    left++;
                } else if (b + c > target) {
                    right--;
                } else {
                    res.add(Arrays.asList(a, b, c));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) left++;
                }
            }
        }
        return res;
    }
}