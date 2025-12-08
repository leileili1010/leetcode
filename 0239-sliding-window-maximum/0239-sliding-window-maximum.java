class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. initialization
            // maxHeap to save int[num, index], the top is the max for certain maxSlidingWindow
        // 2. slide window, 
            // add new number, check if index of the top should not be included in the window, 
            // keep moving expired element (using while loop)
            // update res array
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]); // int[value, index]

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            maxHeap.offer(new int[]{num, i});

            int start = i-k+1;
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < start) {
                maxHeap.poll();
            }

            if (i+1 < k) continue;
            res[start] = maxHeap.peek()[0];
        }  

        return res;
    }
}