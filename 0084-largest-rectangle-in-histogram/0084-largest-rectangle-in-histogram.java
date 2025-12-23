class Solution {
    public int largestRectangleArea(int[] heights) {
        // 单调栈 - 单调递增，存入的是index
        // 枚举高度， 需要知道宽度
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // <index>, ascending order
        stack.push(-1);
        int max = 0;

        // heights = [2,1,5,6,2,3]
                   // 0 1 2 3 4 5

        for (int i = 0; i <= n; i++) {
            int curHeight = i != n? heights[i]: -1;

            while (stack.size() > 1 && curHeight < heights[stack.peek()]) {
                int idx = stack.pop();
                int left = stack.peek();
                int width = i - left - 1;
                int height = heights[idx];
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
}