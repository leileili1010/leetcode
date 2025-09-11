class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxLen = 0;
        for (int[] trip: trips) {
            maxLen = Math.max(maxLen, trip[2]);
        }

        int[] diff = new int[maxLen+1];
        for (int[] trip: trips) {
            int val = trip[0];
            int start = trip[1];
            int end = trip[2];
            diff[start] += val;
            diff[end] -= val;
        }

        int sum = 0;
        for (int i = 0; i < maxLen+1; i++) {
            sum += diff[i];
            if (sum > capacity) return false;
        }
        return true;
    }
}