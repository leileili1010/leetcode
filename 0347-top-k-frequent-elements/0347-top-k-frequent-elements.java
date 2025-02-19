class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        int[] res = new int[k];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int key: map.keySet()) {
            maxHeap.offer(new int[]{key, map.get(key)});
        }

        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll()[0];
        }

        return res;
    }
}