class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // sort meetings by start time;
        // using two minHeaps, freeRooms(sort by number) and usedRooms (sort by end time)
        // loop through meetings
            // case 1: free room available, poll freeRoom and move it to usedRoom, update count
            // case 2: no free room available
                // find the earliest end meeting from the used room
                // update new end time = used room end + original duration
                // udate count

        // 1. sort meeting numbers
        Arrays.sort(meetings, (a,b) -> (a[0] - b[0]));

        // 2. put rooms in minHeaps
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>(); // <roomNumber>
        for (int i = 0; i < n; i++) freeRooms.offer(i);

        // 3. loop through meetings and assign rooms
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a,b) -> 
        a[0] == b[0]? Long.compare(a[1], b[1]): Long.compare(a[0], b[0])); //<endTime, roomNumber>
        int[] count = new int[n];

        for (int[] meeting: meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // 1) released usedRoom if meeting finishes
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                freeRooms.offer((int)usedRooms.poll()[1]);
            }

            // 2) 
            int room;
            if (freeRooms.isEmpty()) {
                long[] earliest = usedRooms.poll();
                end = earliest[0] + duration;
                room = (int)earliest[1];
            } else {
                room = freeRooms.poll();
            }

            usedRooms.offer(new long[] {end, room});
            count[room]++;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) res = i;
        }

        return res;

    }
}