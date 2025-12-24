class Solution {
    public int largestRectangleArea(int[] heights) {
        // 单调栈，单调递增，<index>

        Deque<Integer> stack = new ArrayDeque<>(); // <index>, ascending order
        stack.push(-1);
        int n = heights.length;
        int res = 0;

        for (int i = 0; i <= n; i++) {
            int curHeight = i != n? heights[i]: -1;

            while (stack.size() > 1 && curHeight < heights[stack.peek()]) {
                int idx = stack.pop();
                int left = stack.peek();
                int height = heights[idx];
                int width = i - left - 1;
                res = Math.max(res, height * width);
            }
            stack.push(i);
        }
        return res;
    }
}