class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0;

        while (left < right) { // left = 1, right = 6
            max = Math.max(max, Math.min(height[left], height[right]) * (right-left)); // max = 49
            if (height[left] < height[right]) {
                left++; // left = 1
            } else {
                right--;
            }
        }
        return max;
    }
}