class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left <= right) {
            int mid = left + (right-left)/2;
            long hours = 0;
            for (int pile: piles) {
                hours += pile % mid == 0? pile / mid: pile/mid+1;
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