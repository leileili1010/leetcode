class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image;

        int rows = image.length, cols = image[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir: DIRS) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];

                if (x >= 0 && x < rows && y >= 0 && y < cols && image[x][y] == original) {
                    queue.offer(new int[]{x, y});
                    image[x][y] = color;
                } 
            }
        }
        return image;
    }
}