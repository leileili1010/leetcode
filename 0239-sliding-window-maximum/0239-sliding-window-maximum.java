class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. initialization
            // queue to save index
        // 2. slide window, 
            // enter the window: 
                // if the prior elements in queue are less than the current number, keeping polling (while loop)
                // add current index to queue
                // remove expired index from queue if it is expired
        // 3. update res array, the max for res[i] is the first elemnt (most left) in the queue
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> queue = new ArrayDeque<>(); // index        

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // add num and remove invalid from the window
            while (!queue.isEmpty() && num >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);

            // remove expired index 
            int left = i-k+1;
            if (queue.getFirst() < left) queue.removeFirst();

            if (i + 1 < k) continue;

            res[i-k+1] = nums[queue.getFirst()];
        }  

        return res;
    }
}