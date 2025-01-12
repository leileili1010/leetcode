class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // edge case
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }

        // construct graph and inDegree
        int[] inDegree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        createGraph(graph, inDegree, n, edges);

        // outter level
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) leaves.add(i);
        }
        
        // remove outter level
        while (n > 2) {
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leave: leaves) {
                for (int node: graph.get(leave)) {
                    inDegree[node]--;
                    if (inDegree[node] == 1) {
                        nextLeaves.add(node);
                    }
                }
            }
            n -= leaves.size();
            leaves = nextLeaves;
        }

        return leaves;
    }

    private void createGraph(List<List<Integer>> graph, int[] inDegree, int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[1]]++;
            inDegree[edge[0]]++;
        }
    }
}