class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();

        for (int[] interval: intervals) {
            int m = res.size();

            if (m > 0 && interval[0] <= res.get(m-1)[1]) {
                res.get(m-1)[1] = Math.max(interval[1], res.get(m-1)[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[0][]);
    }
}