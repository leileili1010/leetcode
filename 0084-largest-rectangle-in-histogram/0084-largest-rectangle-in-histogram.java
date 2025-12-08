class Solution {
    public int largestRectangleArea(int[] heights) {
        // h = heights[i]
        // w = right - left -1
        // monotonic stack, numbers in ascending order
            // loop heights, if current h > prev h, put it in stack
            // if current h <= prev h
                // height = heights[stack.pop()]
                // right = i
                // left = stack.peek() after poping

        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // index
        int maxArea = 0;

        for (int right = 0; right <= n; right++) {
            int curHeight = right == n? -1: heights[right]; 

            while (!stack.isEmpty() && curHeight <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty()? -1: stack.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(right);
        }
        return maxArea;
    }
}