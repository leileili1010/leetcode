class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length-1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Deque<List<Integer>> que = new ArrayDeque<>();

        path.add(0);
        que.offer(path);

        while (!que.isEmpty()) {
            List<Integer> curPath = que.poll();
            int lastNode = curPath.get(curPath.size()-1);
            if (lastNode == target) res.add(new ArrayList<>(curPath));
            else {
                for (int next: graph[lastNode]) {
                    List<Integer> newPath = new ArrayList<>(curPath);
                    newPath.add(next);
                    que.offer(newPath);
                }
            }
        }
        return res;
         
    }
}