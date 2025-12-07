class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;

        for (int i = n-1; i >= 0; i--) {
            if (nums[i] < k) return true;

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                k = stack.pop(); 
            } 
            stack.push(nums[i]);
        }

        return false;
    }
}