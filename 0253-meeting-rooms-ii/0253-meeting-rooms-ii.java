class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> meetings = new ArrayList<>();
        int max = 0, time = 0;

        for (int[] interval: intervals) {
            meetings.add(new int[]{interval[0], 1});
            meetings.add(new int[]{interval[1], -1});
        }

         Collections.sort(meetings, (a,b) -> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);

        for (int[] meeting: meetings) {
            time += meeting[1];
            max = Math.max(max, time);
        }

        return max;
    }
}