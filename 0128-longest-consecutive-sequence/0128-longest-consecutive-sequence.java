class Solution {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // remove duplicates
        for (int num: nums) {
            if (set.isEmpty() || !set.contains(num)) {
                set.add(num);
                minHeap.offer(num);
            }
        }

        int prev = minHeap.peek()-1;
        int len = 0, maxLen = 0;
        
        while (!minHeap.isEmpty()) {
            int cur = minHeap.poll();
            if (cur-1 == prev) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 1;
            }
            prev = cur;
        }
        return maxLen;

    }
}