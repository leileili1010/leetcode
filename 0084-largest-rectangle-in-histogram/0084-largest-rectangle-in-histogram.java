class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0, N = heights.length;

        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int idx = 0;
                while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                    int[] cur = stack.pop();
                    int height = cur[1];
                    idx = cur[0];
                    int size = height * (i - idx);
                    max = Math.max(size, max);  
                }
                stack.push(new int[]{idx, heights[i]});
                continue;
            } 
                
            stack.push(new int[]{i, heights[i]});
        }   
        
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int height = cur[1];
            int idx = cur[0];
            int size = height * (N - idx);
            max = Math.max(size, max);  
        }

        return max;
    }
}