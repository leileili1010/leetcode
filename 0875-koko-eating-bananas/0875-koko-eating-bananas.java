class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search: left = 1, right = max piles
        // calulate time: loop througgh piles 

        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2; // mid = 4

            if (calculateTime(mid, piles) <= h) {
                res = mid; // res = 4
                right = mid - 1; // right = 3
            } else {
                left = mid + 1; // left = 4
            }
        }
        return res;
    }

    private long calculateTime(int k, int[] piles) {
        long res = 0;

        for (int pile: piles) {
            res += pile % k == 0? pile/k : pile/k + 1; // 1+2+2+3
        }

        return res; // 8
    }
}