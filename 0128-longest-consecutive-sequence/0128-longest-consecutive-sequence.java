class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int max = 0;
        for (int num: set) {
            if (set.contains(num-1)) continue;

            int count = 0;
            int cur = num;
            while (set.contains(cur)) {
                count++;
                cur++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}