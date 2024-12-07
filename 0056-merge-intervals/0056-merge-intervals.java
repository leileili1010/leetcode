class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 1) {
            return intervals;
        }

        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] a, int[] b) {
        //         if (a[0] == b[0]) {
        //         return Integer.compare(a[1], b[1]);
        //     }
        //     return Integer.compare(a[0], b[0]);
        // }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int start = intervals[0][0], end = intervals[0][1];

        for (int[] interval: intervals) {
            if (interval[1] < start) {
                res.add(interval);
                start = interval[0];
                end = interval[1];
            } else if (interval[0] > end) {
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