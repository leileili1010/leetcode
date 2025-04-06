class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[] {nums[i], i});
        }
        res[0] = maxHeap.peek()[0];

        for (int i = k; i < nums.length; i++) {
            maxHeap.offer(new int[]{nums[i], i});
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i-k+1) {
                maxHeap.poll();
            }
            res[i-k+1] = maxHeap.peek()[0];
        }

        return res;
    }
}