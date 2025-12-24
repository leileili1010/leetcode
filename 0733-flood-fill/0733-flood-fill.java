class Solution {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original != color) {
            dfs(image, sr, sc, original, color);
        }    
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int original, int color) {
        if (image[sr][sc] != original) return;
        image[sr][sc] = color;

        for (int[] dir: DIRS) {
            int x = dir[0] + sr;
            int y = dir[1] + sc;

            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == original) {
                dfs(image, x, y, original, color);
            } 
        }

    }
}