class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0, N = heights.length;

        for (int i = 0; i < N; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int preHeight = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                max = Math.max(max, preHeight * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int preHeight = heights[stack.pop()];
            int width = N - stack.peek() - 1;
            max = Math.max(max, preHeight * width);
        }

        return max;
    }
}