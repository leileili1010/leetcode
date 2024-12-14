class Solution {
    public void sortColors(int[] nums) {
        int[] countColor = new int[3];
        int idx = 0;

        for (int num: nums) {
            countColor[num]++;
        }

        for (int i = 0; i <= 2; i++) {
                int count = countColor[i];
                while (count > 0) {
                    nums[idx++] = i;
                    count--;
                }
            
        }
    }
}