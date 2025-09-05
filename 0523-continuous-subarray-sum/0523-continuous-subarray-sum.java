class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // subarray length >= 2
        // sum divisible of k
        HashMap<Integer, Integer> map = new HashMap<>(); // <remainder, index>
        int sum = 0;
        map.put(0, 0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) + 1 >= 2) return true;
            } else {
                map.put(remainder, i+1);
            } 
        }
        return false;
    }
}