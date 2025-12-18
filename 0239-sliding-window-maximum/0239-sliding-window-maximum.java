class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Double-Ended Queue，monotonically decreasing，
        // loop through nums
            // int cur = nums[i], if nums[i] >= queue.getLast(), que.removeLast()
            // queue.addLast(cur);
            // if (getFirst() < i-k+1) removeFirst
            // if left < 0 continue
            // update ans

        int n = nums.length; // n = 8
        Deque<Integer> queue = new ArrayDeque<>(); // index
        int[] res = new int[n-k+1];

        // nums = [1,3,-1,-3,5,3,6,7]
        for (int i = 0; i < n; i++) { // i = 7
            // enter queue
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i); // queue: 7

            // leave queue
            int left = i-k+1; // left = 5
            if (queue.getFirst() < left) {
                queue.removeFirst();
            }

            // update res;
            if (left >= 0) {
                res[left] = nums[queue.getFirst()];
            }
        }
        return res; // res: 3, 3, 5, 5, 6, 7
    
    }
}