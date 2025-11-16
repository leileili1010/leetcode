class Pair {
    int index;
    int distance;

    Pair(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}

class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int n = points.length;
        Pair res = new Pair(-1, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            int px = point[0], py = point[1];

            if (x == px || y == py) {
                int distance = Math.abs(x-px) + Math.abs(y-py);
                if (distance < res.distance) {
                    res.index = i;
                    res.distance = distance;
                }
            }
        }
        return res.index;
    }
}