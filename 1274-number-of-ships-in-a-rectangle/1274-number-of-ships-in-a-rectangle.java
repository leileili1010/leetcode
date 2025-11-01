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

        // basecase 1
        if (!sea.hasShips(topRight, bottomLeft)) return 0;

        // base case 2
        if (x1 == x2 && y1 == y2) return 1;

        int x3 = (x1 + x2) /2;
        int y3 = (y1 + y2) /2;

        int count = 0;

        count += countShips(sea, new int[]{x3, y3}, new int[]{x1, y1}); // bottem Left rectangle
        count += countShips(sea, new int[]{x2, y3}, new int[]{x3+1, y1}); // bottom right rectangle
        count += countShips(sea, new int[]{x3, y2}, new int[]{x1, y3+1}); // top left
        count += countShips(sea, new int[]{x2, y2}, new int[]{x3+1, y3+1}); // top right

        return count;
    }
}