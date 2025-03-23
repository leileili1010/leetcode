class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        // Step 1: Determine initial search range
        for (int num : nums) {
            low = Math.max(low, num);  // max single element
            high += num;               // sum of all elements
        }
        return binarySearch(nums, k, low, high);
    }

    private int binarySearch(int[] nums, int k, int low, int high) {
        while (low < high) {
            int mid = low + (high-low)/2;
            if (valid(nums, k, mid)) {
                high = mid;
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
                curSum = num;
                count++;
                if (count > k) return false;
            }
        }
        return true;
    }
}