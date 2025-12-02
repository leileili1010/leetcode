class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // 窗口个数
        int[] q = new int[n];
        int head = 0, tail = -1;

        for (int i = 0; i < n; i++) {
            // 1. 右边入
            while (head <= tail && nums[q[tail]] <= nums[i]) {
                tail--; // 右边出队
            }
            q[++tail] = i; // 右边入队

            // 2. 左边出
            int left = i - k + 1; // 窗口左端点
            if (q[head] < left) { // 队首离开窗口
                head++;
            }

            // 3. 在窗口左端点处记录答案
            if (left >= 0) {
                // 由于队首到队尾单调递减，所以窗口最大值就在队首
                ans[left] = nums[q[head]];
            }
        }

        return ans;
    }
}


