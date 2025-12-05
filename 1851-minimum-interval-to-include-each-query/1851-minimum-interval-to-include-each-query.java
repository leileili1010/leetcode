class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int N = queries.length;
        int[] res = new int[N];
        
        // 1. Pair each query with its index
        int[][] queryPairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            queryPairs[i] = new int[] {queries[i], i};
        }

        // 2. Sort queries and intervals
        Arrays.sort(queryPairs, (a,b) -> a[0]-b[0]); // sort queries by value
        Arrays.sort(intervals, (a,b)->a[0]-b[0]); // sort intervals by start time
        
        // 3. Use a Min-Heap to track valid intervals
        int i = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[1] - a[0]) - (b[1] - b[0]));
        
        // 4. Process each query in sorted order
        for (int[] query: queryPairs) {
            int num = query[0];
            int idx = query[1];

            // 4.1 push all intervals starting <= num, whether they end before or after num
            while (i < intervals.length && intervals[i][0] <= num) {
                minHeap.offer(intervals[i]);
                i++;
            }

            // 4.2 Remove intervals that end < num (no longer valid)
            while (!minHeap.isEmpty() && minHeap.peek()[1] < num) {
                minHeap.poll();
            }

            // 4.3 If any valid interval remains, it's the smallest one
            res[idx] = !minHeap.isEmpty()? minHeap.peek()[1] - minHeap.peek()[0] +1: -1;
           
        }
        return res;        
    }
}