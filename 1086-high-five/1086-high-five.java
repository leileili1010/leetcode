class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item: items) {
            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(id);

            pq.offer(score);
            if (pq.size() > 5) pq.poll();
        }

        int[][] res = new int[map.size()][2];

        int idx = 0;
        for (int key: map.keySet()) {
            PriorityQueue<Integer> pq = map.get(key);
            int sum = 0;
            for (int s: pq) sum += s;
            res[idx][0] = key;
            res[idx][1] = sum / 5;
            idx++;
        }
        return res;
    }
}