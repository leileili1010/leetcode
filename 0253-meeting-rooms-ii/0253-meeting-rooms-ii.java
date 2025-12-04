class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> times = new ArrayList<>();
        int res = 0, count = 0;

        for (int[] interval: intervals) {
            times.add(new int[] {interval[0], 1});
            times.add(new int[]{interval[1], -1});
        }

        Collections.sort(times, (a,b) -> (a[0] - b[0]));

        for (int[] time: times) {
            count += time[1];
            res = Math.max(count, res);
        }

        return res;

    }
}