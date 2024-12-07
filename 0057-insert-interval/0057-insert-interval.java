class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;  // track if we've inserted the merged interval
        
        for (int[] interval : intervals) {
            // If current interval is completely before the new interval
            if (interval[1] < start) {
                result.add(interval);
            } 
            // If current interval is completely after the new interval
            else if (interval[0] > end) {
                // Insert the new interval before adding this one, if not done yet
                if (!inserted) {
                    result.add(new int[] {start, end});
                    inserted = true;
                }
                result.add(interval);
            } 
            // Overlapping intervals, merge them
            else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        
        // If the merged new interval hasn't been inserted, add it now
        if (!inserted) {
            result.add(new int[] {start, end});
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
