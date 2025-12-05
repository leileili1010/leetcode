class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // pair each query with its index, sort
        // sort intervals by left end
        // loop through queries
            // while start < query, push interval to minHeap
            // check expired interval, removed them from minHeap
            // top of minHeap is the response for that query
        
        int n = queries.length;
        int[][] queryPairs = new int[n][2];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> ((a[1]-a[0])-(b[1]-b[0])));
        int[] res = new int[n];

    
        for (int i = 0; i < n; i++) {
            queryPairs[i][0] = queries[i];
            queryPairs[i][1] = i;
        }

        Arrays.sort(queryPairs, (a,b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int i = 0;
        for (int[] queryPair: queryPairs) {
            int query = queryPair[0];
            int idx = queryPair[1];

            while (i < intervals.length && intervals[i][0] <= query) {
                minHeap.offer(intervals[i++]);
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            int[] interval = minHeap.peek();
            res[idx] = !minHeap.isEmpty()? minHeap.peek()[1] - minHeap.peek()[0] +1: -1;
        }
        return res;
    }
}