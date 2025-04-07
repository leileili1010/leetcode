class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 1;
        for (int pile: piles) {
            right = Math.max(right, pile);
        }
        
        int res = 0;
        while (left <= right) {
            int k = left + (right-left)/2;

            if (valid(piles, k, h)) {
                res = k;
                right = k-1;
            } else {
                left = k+1;
            }
        } 
        return res;
    }

    private boolean valid(int[] piles, int k, int h) {
        long hour = 0;
        for (int pile: piles) {
            hour += pile % k == 0? pile/k: pile/k+1;
        }
        return hour <= h;
    }
}