/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        int x1 = bottomLeft[0], y1 = bottomLeft[1];
        int x2 = topRight[0], y2 = topRight[1];

        // base case 1: 无船
        if (!sea.hasShips(topRight, bottomLeft)) return 0;

        // base case 2: 单个点
        if (x1 == x2 && y1 == y2) return 1;

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        int count = 0;
        // 分治递归四个象限
        count += countShips(sea, new int[]{midX, midY}, new int[]{x1, y1});
        count += countShips(sea, new int[]{x2, midY}, new int[]{midX + 1, y1});
        count += countShips(sea, new int[]{midX, y2}, new int[]{x1, midY + 1});
        count += countShips(sea, new int[]{x2, y2}, new int[]{midX + 1, midY + 1});

        return count;
    }
}