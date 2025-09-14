class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int max = 0;

        for (int num: set) { // must loop through set as nums has duplicates 
            if (set.contains(num-1)) continue; // // only start counting from the beginning of a sequence
            
            int cur = num;
            int count = 1;
            while (set.contains(cur+1)) { // Every number is visited at most once in this while loop across the entire execution.
                cur += 1;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}