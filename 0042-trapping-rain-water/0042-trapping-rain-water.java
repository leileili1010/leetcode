class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxLeft = height[left], maxRight = height[right];
        int count = 0;

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                int water = maxLeft - height[left];
                count += water > 0? water: 0;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                int water = maxRight - height[right];
                count += water > 0? water: 0;
                maxRight = Math.max(maxRight, height[right]);
            }
        }

        return count;

        
    }
}