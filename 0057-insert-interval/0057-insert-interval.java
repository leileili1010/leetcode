class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals) {
            int iStart = interval[0];
            int iEnd = interval[1];

            if (iEnd < start) {
                res.add(interval);
            } else if (end < iStart) {
                res.add(new int[]{start, end});
                start = iStart;
                end = iEnd;
            } else {
                start = Math.min(start, iStart);
                end = Math.max(end, iEnd);
            }
        }
        res.add(new int[] {start, end});
        
        return res.toArray(new int[0][]);
    }
}