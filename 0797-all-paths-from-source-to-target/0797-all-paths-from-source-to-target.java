class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int destination = graph.length-1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<List<Integer>> que = new ArrayDeque<>();

        path.add(0);
        que.offer(path);

        while (!que.isEmpty()) {
            List<Integer> curPath = que.poll();
            int last = curPath.get(curPath.size()-1);

            for (int next: graph[last]) {
                List<Integer> newPath = new ArrayList<>(curPath);
                newPath.add(next);
                if (next == destination) {
                    res.add(newPath);
                    continue;
                }
                que.offer(newPath);
            }
        }
        return res;       
    }
}