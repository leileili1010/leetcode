class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0, oddCount = 0, numberOfSubarrays = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) oddCount += 1;
            
            while (oddCount > k ) {
                if (nums[left] % 2 != 0) oddCount -= 1;
                left++;
            } 
            numberOfSubarrays += i - left +1;
        }
        return numberOfSubarrays;
    }
}