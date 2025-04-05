class Solution {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.isEmpty() || !set.contains(num)) { // skip duplicates
                pq.offer(num);
                set.add(num);
            }
        }

        int len = 0, max = 0; 
        int prev = pq.peek()-1; // we made up this prev so len starts from 0;
        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (cur == prev+1) {
                len += 1;
                max = Math.max(len, max);
            } else {
                len = 1;
            }
            prev = cur;
        }
        return max;
    }
}