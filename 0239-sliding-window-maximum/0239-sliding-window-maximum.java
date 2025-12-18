class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0]-a[0])); // int[val, index]
        
        for (int i = 0; i < n; i++) { // i = 5
            maxHeap.offer(new int[]{nums[i], i}); //maxHeap: [1,0] [3,1] [-1,2] [-3,3] [5,4] [3,5]
            
            if (i < k-1) continue;

            // left bound: 
            while (maxHeap.peek()[1] < i-k+1) {
                maxHeap.poll();
            }
            res[i-k+1] = maxHeap.peek()[0]; 
        }
        return res; // res ; {3, 3, 5, 5}
    }
}

// [1,3,-1,-3,5,3,6,7]