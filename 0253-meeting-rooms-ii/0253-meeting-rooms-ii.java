class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        for (int[] interval: intervals) {
            events.add(new int[]{interval[0], 1});
            events.add(new int[]{interval[1], -1});
        }

        Collections.sort(events, (a,b) -> (a[0] == b[0]? a[1]-b[1]: a[0]-b[0]));

        int count = 0, max = 0;
        for (int[] e: events) {
            count += e[1];
            max = Math.max(max, count);
        }

        return max;
    }
}