class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 1. remove duplicates        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        
        // 2. loop set to find the begining of consecutive numbers
        int max = 1;
        for (int num: set) {
            if (set.contains(num-1)) continue;
            
            int cur = num;
            int count = 1;
            while (set.contains(cur+1)) {
                count++;
                max = Math.max(max, count);
                cur = cur+1;
            }
        }

        return max;
    }
}