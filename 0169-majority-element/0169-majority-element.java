class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];

        for (int num: nums) {
            if (candidate == num) {
                count++;
            } else {
                if (count > 0) count--;
                else {
                    candidate = num;
                    count++;
                }
            }
        }

        return candidate;
    }
}