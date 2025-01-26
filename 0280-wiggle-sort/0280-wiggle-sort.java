class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        boolean greatOrEqual = true;
        
        int left = 0, right = 1;
        while (right < n) {
            if (right < n && greatOrEqual && nums[right] < nums[left]) {
                swap(nums, left, right);
            } else if (right < n && !greatOrEqual && nums[right] > nums[left]) {
                swap(nums, left, right);
            }
            left++;
            right++;
            greatOrEqual = !greatOrEqual;
        }
    }

     private void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
    }
}