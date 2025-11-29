class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                int water = leftMax - height[left];
                res += water > 0? water: 0;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                int water = rightMax - height[right]; 
                res += water > 0? water: 0;
                rightMax = Math.max(rightMax, height[right]);
            }
        } 
        return res;
    }
}