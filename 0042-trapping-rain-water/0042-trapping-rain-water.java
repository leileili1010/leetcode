class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int N = height.length;
        int[] left = new int[N], right = new int[N];

        for (int i = 1; i < N; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        for (int i = N-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            res += water > 0? water: 0;
        }
        return res;
    }
}