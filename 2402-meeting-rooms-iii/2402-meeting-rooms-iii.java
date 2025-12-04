class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // 1. sort meetings by start time
        // 2. use two minHeaps
            // freeRooms: room number, put all rooms in it
            // usedRooms: int[endtime, roomNumber]
        // 3. loop through meetings
            // 1) first check if any used room finishes and could be put in freeRooms
            // 2) case1: no free room
                // pull used room and put in avaible room
                // update end time for meeting used room end + current duration
            // 3) case2: free room availbe: 
                // poll free room, update used room, count++
        
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        ); // [endTime, roomNo]
        int[] count = new int[n];
        
        for (int i = 0; i < n; i++) freeRooms.offer(i);
        
        for (int[] meeting: meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // check if any usedRooms becomes free atp
            while (!usedRooms.isEmpty() && start >= usedRooms.peek()[0]) {
                freeRooms.offer((int)usedRooms.poll()[1]);
            }

            // case 1: no free rooms
            if (freeRooms.isEmpty()) {
                long[] earliest = usedRooms.poll();
                freeRooms.offer((int)earliest[1]);
                end = earliest[0] + duration;
            }

            // case 2: free rooms available
            int room = freeRooms.poll();
            usedRooms.offer(new long[]{end, room});
            count[room]++;
        }

        int res = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[res]) {
                res = i;
            }
        }    

        return res;
    }
}