class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];
        int res = 0;

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                int water = maxLeft - height[left];
                res += water > 0? water: 0;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                int water = maxRight - height[right];
                res += water > 0? water: 0;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return res;
    }
}