class Solution {
    public int trap(int[] height) {
       // two pointers: left & right to track maxLeft and maxRight
       // compare maxLeft and maxRight values, move the pointer with the smaller maxValue
       // calculate water = maxLeft/right - height[i]
       // update maxleft or maxRight
       int N = height.length;
       int left = 0, right = N-1;
       int maxLeft = height[left], maxRight = height[right];
       int res = 0;

       while (left < right) {
            if (maxLeft < maxRight) {
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