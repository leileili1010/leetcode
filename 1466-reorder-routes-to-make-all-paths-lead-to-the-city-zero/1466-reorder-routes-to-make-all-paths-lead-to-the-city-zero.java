class Solution {
    int res = 0;

    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] connection: connections) {
            map.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(new int[] {connection[1], 1});
            map.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(new int[] {connection[0], 0});
        }

        bfs(map, visited, 0);
        return res;
    }

    public void bfs(HashMap<Integer, List<int[]>> map, Set<Integer> visited, int start) {
        Deque<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited.add(start);

        while (!que.isEmpty()) {
            int node = que.poll();
            for (int[] neighbor: map.get(node)) {
                int nextNode = neighbor[0];
                int direction = neighbor[1];

                if (visited.add(nextNode)) {
                    que.offer(nextNode);
                    res += direction;
                }
            }
        }



    }
}