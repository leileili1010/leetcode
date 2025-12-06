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

        
        int[] count = new int[n];
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>(); // room nubmer;
       PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        ); // <endTime, room numnber>
        
        Arrays.sort(meetings, (a,b) -> (a[0] - b[0]));

        for (int i = 0; i < n; i++) freeRooms.offer(i);

        for (int[] meeting: meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // release used rooms with finished meetings
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                freeRooms.offer((int)usedRooms.poll()[1]);
            }

            int room;
            if (freeRooms.isEmpty()) {
                long[] earliest = usedRooms.poll();
                end = earliest[0] + duration;
                room = (int)earliest[1];
            } else {
                room = freeRooms.poll();
            }

            usedRooms.offer(new long[]{end, room});
            count[room]++;
        } 

        int res = 0;
        for (int i = 1; i < count.length; i++) {
            if (count[i] > count[res]) res = i;
        }
        return res;

    }
}