class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        boolean greatOrEqual = true;
        
        int left = 0, right = 1;
        while (right < n) {
            if (right < n && greatOrEqual && nums[right] < nums[left]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            } else if (right < n && !greatOrEqual && nums[right] > nums[left]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            left++;
            right++;
            greatOrEqual = !greatOrEqual;
        }

    }
}