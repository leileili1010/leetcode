class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int numberOfSubarrays = 0, left = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

            while (map.size() > k) {
                int num = nums[left];
                map.put(num, map.get(num)-1);
                if (map.get(num) == 0) map.remove(num);
                left++;
            }
            numberOfSubarrays += i-left+1;
        }
        return numberOfSubarrays;
    }
}