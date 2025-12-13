class Solution {
    public int largestRectangleArea(int[] heights) {
        // initialization: 
            // monotonic stack, index, in descending order
        // 枚举 
            // loop through heights，
            // if num > prev, put in stack
            // else pop and calcuate area 

        
        int res = 0, n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // index, in descending order

        for (int i = 0; i <= n; i++) { // i = 6
            int curheight = i == n? -1: heights[i]; // curheight = -1

            while (!stack.isEmpty() && curheight < heights[stack.peek()]) { // T
                int height = heights[stack.pop()]; // h = 2
                int left = stack.isEmpty()? -1: stack.peek();// left = 1
                int width = i-left-1; // w = 4
                res = Math.max(res, height * width); // res = 10
            } 

            stack.push(i); // stack: 1
        }
        return res;
    }
}


