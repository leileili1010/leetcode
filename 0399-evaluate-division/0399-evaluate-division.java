class Pair {
    String node;
    double value;

    Pair(String node, double value) {
        this.node = node;
        this.value = value;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // construct a graph using hashmap, e.g. "a" is key, [["b", 2.0], ...] as value
        // loop through queries, leverage graph to find the accumulated product == target product

        HashMap<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String node = equations.get(i).get(0);
            String nextNode = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(node, k -> new ArrayList<>()).add(new Pair(nextNode, value));
            graph.computeIfAbsent(nextNode, k -> new ArrayList<>()).add(new Pair(node, 1/value));
        }

        double[] res =  new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            res[i] = bfs(graph, start, end);
        }

        return res;
    }

    public double bfs(HashMap<String, List<Pair>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }

        Deque<Pair> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        que.add(new Pair(start, 1.0));
        visited.add(start);
        
        while (!que.isEmpty()) {
            Pair curr = que.poll();
            String node = curr.node;
            double product = curr.value;
            if (node.equals(end)) {
                return product;
            }

            for ( Pair neighbor: graph.get(node)) {
                if (visited.add(neighbor.node)) {
                    que.add(new Pair(neighbor.node, product*neighbor.value));
                }
            }
        }   
        return -1.0; 
    }
}