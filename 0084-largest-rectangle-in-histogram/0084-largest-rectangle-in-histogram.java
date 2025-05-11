class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < N; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int preHeight = heights[stack.pop()];
                int width = i - stack.peek()-1;
                int area = preHeight * width;
                max = Math.max(max, area);
            } 
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int preHeight = heights[stack.pop()];
            int width = N - stack.peek() -1;
            int area = preHeight * width;
            max = Math.max(max, area);  
        }

        return max;
    }

}