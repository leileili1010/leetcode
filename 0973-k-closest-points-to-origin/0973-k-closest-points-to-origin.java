class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] res = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int distance = squareDistance(points[i]);
            int[] pair = {distance, i};
            minHeap.add(pair);
        }
        
        for (int i = 0; i < k; i++) {
            int[] pair = minHeap.poll();
            int idx = pair[1];
            res[i] = points[idx]; 
        }

        return res;
        
    }

    private int squareDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}