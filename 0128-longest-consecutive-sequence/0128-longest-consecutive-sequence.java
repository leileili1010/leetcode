class Solution {
    public int longestConsecutive(int[] nums) {
        // 1. remove duplicates        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        
        // 2. loop set to find the begining of consecutive numbers
        int max = 0;
        for (int num: set) {
            if (set.contains(num-1)) continue;
            
            int cur = num;
            int count = 1;
            while (set.contains(cur+1)) {
                count++;
                cur = cur+1;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}