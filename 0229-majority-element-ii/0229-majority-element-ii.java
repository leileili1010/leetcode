class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Integer c1 = null, c2 = null;
        int count1 = 0, count2 = 0;

        for (int num: nums) {
            if (c1 != null && c1 == num) {
                count1++;
            } else if (c2 != null && c2 == num) {
                count2++;
            } else if (count1 == 0) {
                c1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                c2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num: nums) {
            if (c1 != null && num == c1) count1++;
            else if (c2 != null & num == c2) count2++;
        }

        int threshold = nums.length / 3;
        if (count1 > threshold) res.add(c1);
        if (count2 > threshold) res.add(c2);

        return res;
        
    }
}