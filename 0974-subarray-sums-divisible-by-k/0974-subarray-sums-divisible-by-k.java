class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // <remainder, count>
        int sum = 0, res = 0;
        map.put(sum % k, 1);

        for (int num: nums) {
            sum += num;
            int remainder = ((sum % k) + k) % k;
            if (map.containsKey(remainder)) res += map.get(remainder);
            map.put(remainder, map.getOrDefault(remainder, 0)+1); 

        }
        return res;
        
    }
}