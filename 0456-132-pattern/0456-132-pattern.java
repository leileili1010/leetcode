class Solution {
    public boolean find132pattern(int[] nums) {
        // monotonic stack for j number, in decreasing order
        // loop from right to left
            // if new number is smaller then prev one, put it in stack
            // if new number is greater than prev one, keep poping out previous numbers -- k number
        // find one more number that's smaller than k, return true
        // return false

        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(); // number
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