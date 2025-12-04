class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // This ensures that meetings are processed in the order they begin. Sorting is necessary so we can process meetings one by one in chronological order.
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);
        
        // The min-heap keeps track of the earliest ending meetings.
        // It always has the meeting that ends soonest at the top (peek()).
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);


        // For each new meeting interval, you check if it can reuse an existing room:
            //If its start time interval[0] is after or equal to the earliest ending meeting (meeting[1]), then a room is free.
            // You poll() that meeting — i.e., free the room.
            // Then, you add the current meeting to the heap:
            // This reserves a room (either a reused one or a new one).
        for (int[] interval: intervals) {
            if (!minHeap.isEmpty()) {
                int[] meeting = minHeap.peek();
                if (interval[0] >= meeting[1]) {
                    minHeap.poll();
                }
            }
            minHeap.add(interval);
        }
        
        // the size of the heap reaches is the minimum number of rooms required.
        return minHeap.size();
    }
}