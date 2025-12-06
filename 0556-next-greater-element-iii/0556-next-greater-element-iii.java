class Solution {
    public int nextGreaterElement(int n) {
        // 1. convert n to int[] nums
        // 2. find pivot: from right to left, find nums[i] < nums [i+1]
        // 3. find exchange: from right to left, find the first num > nums[i]
        // 4. swap
        // 5. convert nums to n, check for overflow

        char[] nums = String.valueOf(n).toCharArray();
        int N = nums.length;
        int i = N-2;

        while (i >= 0 && nums[i] >= nums[i+1]) i--;

        if (i < 0) return -1;

       
        int j = N-1;

        while (j > i && nums[j] <= nums[i]) j--;
        swap(nums, i, j);
        

        reverse(nums, i+1, N-1);

        try {
            return Integer.parseInt(new String(nums));
        } catch(Exception e) {
            return -1;
        }
    }

    private void reverse(char[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private void swap (char[] nums, int a, int b) {
        char temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}