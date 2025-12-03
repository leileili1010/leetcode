class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];

        for (int[] interval: intervals) {
            int start = interval[0], end = interval[1];
            if (start > current[1]) {
                res.add(current);
                current = interval;
            } else {
                current[1] = Math.max(current[1], end);
            }
        }

        res.add(current);

        return res.toArray(new int[0][]);
        
        
    }
}