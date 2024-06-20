class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>(); // answer
        List<Integer> path = new ArrrayList<>();
        Deque<List<Integer>> que = new ArrayDeque<>(); // to store current path

        path.add(0);
        que.add(path);

        while (!que.isEmpty()) {
            List<Integer> currPath = que.poll();
            int lastNode = currPath.get(currPath.size()-1);
            if (lastNode == graph.length-1) {
                paths.add(new ArrayList<>(currPath));
                continue;
            }
            for (int num: graph[lastNode]) {
                List<Integer> newPath = new ArrayList<>(currPath);
                newPath.add(num);
                que.add(newPath);
            }
        }
        return paths;
    }
}