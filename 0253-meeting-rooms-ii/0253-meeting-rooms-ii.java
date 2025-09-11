class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // 1. sort by start time
        Arrays.sort(intervals, (a,b) -> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        for (int[] interval: intervals) {
           if (!minHeap.isEmpty()){ 
                int[] meeting = minHeap.peek();
                if (interval[0] >= meeting[1]) minHeap.poll(); 
            }
            minHeap.offer(interval);
        }
        return minHeap.size();

    }
}