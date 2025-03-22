class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int left = 0, count = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) == 1) {
                k--; // new unique number
            }

            while (k < 0) {
                int leftNum = nums[left];
                freq.put(leftNum, freq.get(leftNum) - 1);
                if (freq.get(leftNum) == 0) {
                    k++; // removed a unique number
                }
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
