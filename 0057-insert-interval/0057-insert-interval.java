class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] cur: intervals) {
            // scenario 1: newInterval already inserted(null) or cur < newInterval (no overlap) 
            if (newInterval == null || cur[1] < newInterval[0]) list.add(cur);
            // scenario 2: cur > newInterval (no overLap);
            else if (newInterval[1] < cur[0]) {
                list.addAll(List.of(newInterval, cur));
                newInterval = null; // mark newInterval as inserted already(null);
            } else { // scenario 3: overLap
                newInterval[0] = Math.min(newInterval[0], cur[0]);
                newInterval[1] = Math.max(newInterval[1], cur[1]);
            }
        }

        if (newInterval != null) { // when all cur < newInterval (no overLap), we need to mannually add newiterval to the end
            list.add(newInterval);
        }

        return list.toArray(new int[0][]);
    }
}