class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left  < right) { // 保证at least 有两个数才开始while loop
            int mid = left + (right - left)/2;
            if (mid % 2 == 1) mid--; // 保证mid是偶数

            if (nums[mid] == nums[mid+1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}