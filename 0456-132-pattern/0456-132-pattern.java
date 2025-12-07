class Solution {
    public boolean find132pattern(int[] nums) {
        // i < j < k, nums[i] < nums[k] < nums[j]
        // loop from right to left to first find j and k
            // stack to save j, must be decreasing
            // if encountring nums[i] > stack.peek(), pop as nums[k] and put nums[i] in stack
            // we only need one more number that's smaller than nums[k] and we find the answer

        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(); // for nums[j]
        int numK = Integer.MIN_VALUE;

        for (int i = n-1; i >= 0; i--) {
            if (nums[i] < numK) return true;

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                numK = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;

    }
}