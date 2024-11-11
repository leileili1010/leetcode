class Solution {
    public int majorityElement(int[] nums) {
        int max = 0, res = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (map.get(num) > max) {
                max = map.get(num);
                res = num;
            } 
        }

        return res;
    }
}