class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // construct frequency map
        // maxHeap<int[num, freq]> sort by frequencey
        // pop k times

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[1]-a[1]));
        int[] res = new int[k];
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
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