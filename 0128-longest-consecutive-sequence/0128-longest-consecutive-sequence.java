class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num: nums) {
            if (set.add(num)) {
                heap.add(num);
            }
        }

        int res = 0;
        int count = 0;
        int pre = Integer.MAX_VALUE;
       
        while (!heap.isEmpty()) {
            int n = heap.poll();
            if (n - pre == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
            pre = n;
        }   

        return res+1;     
    }
}