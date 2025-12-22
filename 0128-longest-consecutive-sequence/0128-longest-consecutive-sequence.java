class Solution {
    public int longestConsecutive(int[] nums) {
        // initialization: put all numbers in set
        // find starting point
            // loop, start is when num-1 is not in set
            // if not start, continue;
            // if start, count and update res

        // nums = [100,4,200,1,3,2]
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int max = 0;
        for (int num: set) {
            if (set.contains(num-1)) continue;
            
            int count = 1;
            while(set.contains(++num)) {
                count++;
            }
            max = Math.max(max, count); // 4
        }
        return max;
    }
}