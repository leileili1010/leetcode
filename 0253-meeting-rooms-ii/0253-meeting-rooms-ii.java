class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        for (int[] interval: intervals) {
            if (!minHeap.isEmpty() && interval[0] >= minHeap.peek()[1]) {
                minHeap.poll();
            } 

            minHeap.offer(interval);
        }
        return minHeap.size();



    }
}