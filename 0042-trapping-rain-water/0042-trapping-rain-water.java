class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        int maxLeft = height[left], maxRight = height[right];

        while (left < right) {
            if (maxLeft <= maxRight) {
                left++;
                res += maxLeft - height[left] >= 0? maxLeft - height[left]: 0;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                res += maxRight - height[right] >= 0? maxRight - height[right]: 0;
                maxRight = Math.max(maxRight, height[right]); 
            }
        }

        return res;
    }
}