class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int N = queries.length;
        int[] res = new int[N];

        int[][] queryPairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            queryPairs[i] = new int[] {queries[i], i};
        }

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Arrays.sort(queryPairs, (a,b) -> a[0] -b[0]);

        int i = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[1]-a[0])-(b[1]-b[0]));

        for (int[] query: queryPairs) {
            int num = query[0];
            int idx = query[1];

            while (i < intervals.length && intervals[i][0] <= num) {
                minHeap.offer(intervals[i]);
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < num) {
                minHeap.poll();
            }

            res[idx] = !minHeap.isEmpty()? minHeap.peek()[1]-minHeap.peek()[0]+1: -1;
        }

        return res;
    }
}