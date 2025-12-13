class Solution {
    public int longestConsecutive(int[] nums) {
        // 1.Set: put all numbers in set, easy to find the start of a consecutive series
        // 2.find starting point:
            // loop through nums, if set contains num-1, continue;
            // from starting point to consecutive
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int res = 0;

        for (int num: nums) {
            if (set.contains(num-1)) continue;
            int count = 1;
            
            while(set.contains(num+1)) {
                count++;
                num += 1;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}