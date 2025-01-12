class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++){
                res.add(i);
            }
            return res;
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        createGraph(edges, graph, inDegree, n);

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) leaves.add(i);
        } 

        while (n > 2) {
            List<Integer> nextLeaves = new ArrayList<>();
            for (int leaf: leaves) {
                for (int node: graph.get(leaf)) {
                    inDegree[node]--;
                    if (inDegree[node] == 1) nextLeaves.add(node);
                }
            }
            n -= leaves.size();
            leaves = nextLeaves;
        }
       
        return leaves;
    }

    private void createGraph(int[][] edges, List<List<Integer>> graph, int[] inDegree, int n) {
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
    }
}