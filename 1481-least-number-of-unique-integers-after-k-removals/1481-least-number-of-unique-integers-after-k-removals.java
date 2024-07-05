class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: map.values) {
            pq.add(num);
        }

        int elementsRemoved = 0;
        while (!pq.isEmpty()) {
            elementsRemoved += pq.peek();
            if (elementsRemoved > k) {
                return pq.size;
            }
            pq.poll();
        }
        return 0;
    }
}