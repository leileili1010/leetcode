class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // maxHeap: put first k nodes ([number, index]) in int
        // put top in res array
        // move window forward
            // add new element to maxHeap
            // check if top is out of boundray

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] - a[0]));
        int n = nums.length; // n =8
        int[] res = new int[n-k+1]; // 8-5+1 = 4
        
        for (int i = 0; i < k; i++) {
            maxHeap.offer(new int[]{nums[i], i});
        }
        res[0] = maxHeap.peek()[0];
        
        // i is right pointer
        for (int i = k; i < n; i++) { // i = 7 (i < 8)
            maxHeap.offer(new int[]{nums[i], i});
            
            // check if top is out of boundray
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] < i-k+1) {
                maxHeap.poll();
            }

            res[i-k+1] = maxHeap.peek()[0];
        }
        return res; // 10, 10, 9, 
    }
}