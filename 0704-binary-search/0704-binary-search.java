class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return -1;

    }
}