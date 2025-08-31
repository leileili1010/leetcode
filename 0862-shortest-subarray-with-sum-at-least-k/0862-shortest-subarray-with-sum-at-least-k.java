

import static java.util.Collections.min;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = getPrefixSum(nums);
        int N = prefixSum.length;
        int minLen = Integer.MAX_VALUE; 

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while(!que.isEmpty() && prefixSum[que.peekLast()] >= prefixSum[i]) {
                que.pollLast();
            }
            while (!que.isEmpty() && prefixSum[i] - prefixSum[que.peekFirst()] >= k) {
                minLen = Math.min(minLen, i-que.pollFirst());
            }
            que.offerLast(i);
        }
        return minLen == Integer.MAX_VALUE? -1: minLen;

    }

    private long[] getPrefixSum(int[] nums) {
        long[] prefixSum = new long[nums.length+1];

        for (int i = 0; i < nums.length; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        return prefixSum;
    }
}