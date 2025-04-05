class Solution {
    public int trap(int[] height) {
        int N = height.length;
        int left = 0, right = N-1, res = 0;
        int maxLeft = height[left], maxRight = height[right];
        
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