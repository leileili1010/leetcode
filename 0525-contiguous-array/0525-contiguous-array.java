class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); //<sum, index>
        map.put(0, 0);
        int sum = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0? -1: nums[i];
            if (map.containsKey(sum-0)) {
                int len = i-map.get(sum)+1;
                maxLen = Math.max(len, maxLen);
            } else {
                map.put(sum, i+1);
            }
        }
        return maxLen == Integer.MIN_VALUE? 0: maxLen;
    }
}