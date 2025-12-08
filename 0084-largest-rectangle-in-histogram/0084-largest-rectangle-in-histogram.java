class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int N = heights.length;

        for (int i = 0; i <= N; i++) {
            int curHeight = i == N? 0: heights[i];

            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty()? i: i - stack.peek()-1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}