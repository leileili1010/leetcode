class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int iStart = intervals[i][0];
            int iEnd = intervals[i][1];

            if (iStart > end) {
                res.add(new int[] {start, end});
                start = iStart;
                end = iEnd;
            } else {
                end = Math.max(end, iEnd);
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}