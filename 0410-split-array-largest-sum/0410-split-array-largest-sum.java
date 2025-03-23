class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        return binarySearch(nums, k, low, high);
    }

    private int binarySearch(int[] nums, int k, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;
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
                curSum = num;
                count++;
                if (count > k) return false;
            }
        }
        return true;
    }
}