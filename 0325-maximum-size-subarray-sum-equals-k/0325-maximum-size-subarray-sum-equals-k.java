class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <sum, index>
        map.put(0, 0);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k)) {
                int len = i - map.get(sum-k)+1;
                maxLen = Math.max(len, maxLen);
            } 

            if (!map.containsKey(sum)) map.put(sum, i+1);
        }
        return maxLen;
    }
}