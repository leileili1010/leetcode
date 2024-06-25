class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> que = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        que.offer(0);
        visited.add(0);

        while (!que.isEmpty()) {
            int cur = que.poll();
            
            for (int v: rooms.get(cur)) {
                if (visited.add(v)) {
                    que.offer(v);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}