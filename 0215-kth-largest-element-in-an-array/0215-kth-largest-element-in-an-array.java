class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int res = nums[0];
        for (int i = 0; i < k; i++) {
            res = maxHeap.poll();
        }

        return res;
        
    }
}