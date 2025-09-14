class Solution {
    public int[][] highFive(int[][] items) {
        // 学生 id -> 最小堆（保存 top 5 分数）
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int[] item : items) {
            int id = item[0], score = item[1];
            map.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(id);
            
            pq.offer(score);
            if (pq.size() > 5) {
                pq.poll(); // 删除最小的，保证只留 top 5
            }
        }
        
        // 输出结果
        int[][] res = new int[map.size()][2];
        int idx = 0;
        
        List<Integer> ids = new ArrayList<>(map.keySet());
        Collections.sort(ids); // 学生 id 升序
        
        for (int id : ids) {
            PriorityQueue<Integer> pq = map.get(id);
            int sum = 0;
            for (int s : pq) sum += s;
            res[idx][0] = id;
            res[idx][1] = sum / pq.size(); // 取平均
            idx++;
        }
        
        return res;
    }
}