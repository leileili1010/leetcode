class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // Use 0 as a sentinel height at the end
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Pop from stack while the current bar is smaller than the one at the top
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int top = stack.pop();
                int height = heights[top];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}