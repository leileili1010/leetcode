class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxArea = 0;

        while (left < right) {
            int num1 = height[left], num2 = height[right];
            maxArea = Math.max(maxArea, Math.min(num1, num2) * (right-left));
            if (num1 < num2) left++;
            else right--;
        }
        return maxArea;
        
    }
}