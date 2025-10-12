class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int count = 0;

        for (int i = N-1; i >= 2; i--) {
            int c = nums[i];
            int left = 0, right = i-1;
            while (left < right) {
                int a = nums[left];
                int b = nums[right];
                if (a+b > c) {
                    count += right-left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}