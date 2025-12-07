class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        int res = 0;

        while (left <= right) {
            int mid = left + (right-left)/2;
            
            if (canShip(weights, mid, days)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private boolean canShip(int[] weights, int cap, int days) {
        int usedDays = 1;
        int curLoad = 0;

        for (int w: weights) {
            if (curLoad + w > cap) {
                usedDays++;
                curLoad = 0;
            } 
            curLoad += w;

            if (usedDays > days) return false;
        }
        return true;
    }
}