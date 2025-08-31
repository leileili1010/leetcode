class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxLen = 0;
        for (int[] trip: trips) {
            maxLen = Math.max(maxLen, trip[2]); // 7
        }

        int[] diff = new int[maxLen + 1]; // 8

        for (int[] trip: trips) {
            int val = trip[0]; //3
            int start = trip[1]; // 5
            int end = trip[2]; // 7
            diff[start] += val; // 
            diff[end] += -val;
         }
        
        int sum = 0; 
        for (int i = 0; i < diff.length; i++) { // i = 4
            sum += diff[i]; // 0 + 2 = 2
            if (sum > capacity) return false; // false
            diff[i] = sum; // 
        }
        return true;
    }
}

// 0 1 2 3 4  5   6  7
//   2       -2
//            3     -3
// 0 2 2 2 2  
