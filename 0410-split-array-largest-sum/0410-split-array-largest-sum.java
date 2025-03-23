class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        // Step 1: Determine initial search range
        for (int num : nums) {
            low = Math.max(low, num);  // max single element
            high += num;               // sum of all elements
        }

        // Step 2: Binary search
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;  // try smaller max sum
            } else {
                low = mid + 1;  // increase max sum
            }
        }

        return low; // or high — they are equal at this point
    }

    // Helper function: can we split into ≤ k subarrays with max sum ≤ target?
    private boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int count = 1;  // we always have at least 1 subarray
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                count++;  // start a new subarray
                currentSum = num;

                if (count > k) return false; // too many subarrays
            } else {
                currentSum += num;
            }
        }

        return true;
    }
}