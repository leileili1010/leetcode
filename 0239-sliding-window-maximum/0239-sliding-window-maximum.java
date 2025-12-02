class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // sliding window moves 
        // maxHeap to easily grab the max during the window, maxHeap<int[num, index]>
            // when new number entering the window: put new number in maxHeap
            // when old number leaving the window: only update if it is the max
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] - a[0]));

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        res[0] = maxHeap.peek()[0];

        for (int i = k; i < n; i++) {
            maxHeap.offer(new int[]{nums[i], i});

            while (maxHeap.peek()[1] < i-k+1) {
                maxHeap.poll();
            }

            res[i-k+1] = maxHeap.peek()[0]; 
        }
        return res;
    }
}