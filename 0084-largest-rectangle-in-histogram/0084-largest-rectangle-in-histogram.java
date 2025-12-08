class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 在栈中只有一个数的时候，栈顶的「下面那个数」是 -1，对应 left[i] = -1 的情况
        int ans = 0;
        for (int right = 0; right <= n; right++) {
            int h = right < n ? heights[right] : -1;
            while (st.size() > 1 && heights[st.peek()] >= h) {
                int i = st.pop(); // 矩形的高（的下标）
                int left = st.peek(); // 栈顶下面那个数就是 left
                ans = Math.max(ans, heights[i] * (right - left - 1));
            }
            st.push(right);
        }
        return ans;
    }
}
