class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0, 0);

        for (int i = 0; i < nums.length; i++) { // i = 2
            sum += nums[i] == 0? -1: nums[i]; // sum = 1

            if (map.containsKey(sum)) {
                res = Math.max(res, i+1-map.get(sum)); // res = 2
            } else {
                map.put(sum, i+1); 
            }
        }

        return res;       
    }
}