class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // Find the max value in piles
        int res = right; // we know for sure this must work;

        while (left <= right) {
            int k = left + (right-left)/2;
            long hours = 0; // Use long to prevent overflow
            for(int p: piles) {
                int curh = p % k == 0? p/k: p/k+1;
                hours += curh; 
            }

           if (hours <= h) {
                res = k;
                right = k-1;
            } else {
                left = k+1;
            }
        }
        return res;
    }
}
