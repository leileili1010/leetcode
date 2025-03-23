class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num: nums) {
            low = Math.max(num, low);
            high += num;
        }

        int mid = 0;
        while (low <= high) {
            mid = low + (high-low)/2;
            if (valid(nums, k, mid)) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean valid(int[] nums, int k, int maxSubarraySum) {
        int count = 1, curSum = 0;

        for (int num: nums) {
            curSum += num;
            if (curSum > maxSubarraySum) {
                count++;
                curSum = num;
                if (count > k) return false;
            }
        }
        return true;
    }
}