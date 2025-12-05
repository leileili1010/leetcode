class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[][] queryPairs = new int[n][2];

        // 1. build queryPair from queries
        for (int i = 0; i < n; i++) {
            queryPairs[i][0] = queries[i];
            queryPairs[i][1] = i;
        }

        // 2. sort intervals and queryPairs
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        Arrays.sort(queryPairs, (a,b) -> (a[0] - b[0]));

        // 3. use minHeap to find out the shortest distance
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> ((a[1]-a[0])-(b[1]-b[0])));
        int i = 0;
        int[] res = new int[n];

        for (int[] queryPair: queryPairs) {
            int query = queryPair[0];
            int idx = queryPair[1];

            // 1) put intervals that has a left end <= query in minHeap
            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(intervals[i++]);
            }

            // 2) remove expired interval when its right end <= query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            // 3) update
            res[idx] = minHeap.isEmpty()? -1: minHeap.peek()[1]-minHeap.peek()[0]+1;
        }

        return res;
    }
}