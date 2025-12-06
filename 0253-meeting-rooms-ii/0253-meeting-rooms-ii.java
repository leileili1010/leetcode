class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] == b[0]? a[1]-b[1]: a[0]-b[0]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0]) {
                minHeap.poll();
            } 
            minHeap.offer(interval);
        }

        return minHeap.size();

    }
}