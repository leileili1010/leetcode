class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;

        int start = -1, end = -1;

        for (int[] interval: intervals) {
            int iStart = interval[0];
            int iEnd = interval[1];

            if (start == -1) {
                start = iStart;
                end = iEnd;
                continue;
            }
            
            if (isOverlap(start, end, iStart, iEnd)) return false;
            if (iStart < start) start = iStart;
            if (iEnd > end) end = iEnd;
        }
        return true;
    }

    private boolean isOverlap(int start, int end, int iStart, int iEnd) {
        return (iStart > start && iStart < end) || (iEnd > start && iEnd < end) || (iStart <= start && iEnd >= end); 
    }
}