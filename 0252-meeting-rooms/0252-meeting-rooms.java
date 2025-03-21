class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, (a,b) -> (a[1]-b[1]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int iStart = intervals[i][0];
            int iEnd = intervals[i][1];

            if (iStart < end) {
                return false;
            } else {
                end = iEnd;
            }
        }
        return true;
    }
}