class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0, left = 0;
        for (int pile: piles) {
            right = Math.max(right, pile);
            left = Math.min(left, pile);
        }
        
        while (left < right) {
            int k = left + (right-left)/2;

            if (valid(piles, k, h)) {
                right = k;
            } else {
                left = k+1;
            }
        } 
        return left;
    }

    private boolean valid(int[] piles, int k, int h) {
        int hour = 0;
        for (int pile: piles) {
            hour += pile % k == 0? pile/k: pile/k+1;
        }
        return hour <= h;
    }
}