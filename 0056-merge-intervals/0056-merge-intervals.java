class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];

        for (int[] next: intervals) {

            if (next[0] > cur[1]) {
                res.add(cur);
                cur = next;
            } else {
                cur[1] = Math.max(cur[1], next[1]);
            }
        }

        res.add(cur);
        return res.toArray(new int[0][]); 
    }
}