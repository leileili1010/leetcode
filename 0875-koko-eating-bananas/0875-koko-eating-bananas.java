class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;

            if (validTime(piles, h, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private boolean validTime(int[] piles, int h, int mid) {
        long time = 0;

        for (int pile: piles) {
            time += pile % mid == 0? pile / mid: pile/mid + 1;
        }

        return time <= h;
    }
}