class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0, N = heights.length;

        for (int i = 0; i < N; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                start = stack.peek()[0];
                int size = sizeCalulator(stack, i);
                max = Math.max(size, max);
            }
            stack.push(new int[]{start, heights[i]});
        }   
        
        while (!stack.isEmpty()) {
            int size = sizeCalulator(stack, N);
            max = Math.max(size, max);  
        }

        return max;
    }

    private int sizeCalulator(Deque<int[]> stack, int N) {
        int[] cur = stack.pop();
        int height = cur[1];
        int idx = cur[0];
        int size = height * (N - idx);
        return size;
    }
}