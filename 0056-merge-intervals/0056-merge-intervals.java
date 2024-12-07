class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];

        for (int[] interval: intervals) {
            if (interval[0] > end) {
                res.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            } else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        res.add(new int[] {start, end});
        
        return res.toArray(new int[res.size()][]);
    }
}