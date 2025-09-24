class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int  right = 0, left = 1;
        for (int num: piles) {
            right = Math.max(right, num);
        }

        while (left <= right) {
            int mid = left + (right-left)/2;
            long hours = 0;

            for (int pile: piles) {
                hours += pile % mid == 0? pile/mid: pile/mid+1;
            }

            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}