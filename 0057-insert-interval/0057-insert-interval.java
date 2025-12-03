class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 3 cases 
            // 1. intevals on the left side of new interval, no overlapping, add it to res
            // 2. overlapping, update new interval
            // 3. intervals on the right side of new interval, add it to res
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        
        // case 1: intervals on the left side 
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }

        // case 2: overlapping
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // case 3: intervals on the right side 
        while (i < n) {
            res.add(intervals[i++]);
        }
       
        return res.toArray(new int[0][]);
    }
}