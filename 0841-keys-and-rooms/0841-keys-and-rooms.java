class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> que = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        que.offer(0);

        while (!que.isEmpty()) {
            int curr = que.poll();

            for (int num: rooms.get(curr)) {
                if (visited.add(num)) {
                    que.offer(num);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}