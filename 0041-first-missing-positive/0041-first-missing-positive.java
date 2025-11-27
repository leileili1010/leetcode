class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Put each number in its correct index
        for (int i = 0; i < n; i++) {
            // keep swapping until nums[i] is in the right position, or it can't be placed
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Step 2: find the first index where the number is wrong
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // if all positions are correct, answer is n+1
        return n + 1;
    }
}
