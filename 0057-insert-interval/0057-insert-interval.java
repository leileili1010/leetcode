class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals) {
            int start = interval[0], end = interval[1];

            if (newInterval[0] > end) {
                res.add(interval);
            } else if (newInterval[1] < start) {
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(end, newInterval[1]);
            }
        }

        res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}