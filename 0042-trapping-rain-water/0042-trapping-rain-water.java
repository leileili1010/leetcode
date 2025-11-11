class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i-1], left[i-1]);
        }

        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(height[i+1], right[i+1]);
        }


        for (int i = 0; i < n; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            res += water > 0? water: 0;
        }

        return res;

    }
}