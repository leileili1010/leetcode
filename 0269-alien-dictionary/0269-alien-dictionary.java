class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) return "";
        return topologicalSorting(graph);
    }

    private Map<Character, Set<Character>> constructGraph (String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word: words) {
            for (char c: word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            if (words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])) {
                return null;
            }
            for (int j = 0; j < Math.min(words[i].length(), words[i+1].length()); j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    graph.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                    break;
                }
            }
        }

     return graph;   
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();

        for (char key: graph.keySet()) {
           indegree.put(key, 0);
        }

        for (char key: graph.keySet()) {
            for (char c: graph.get(key)) {
                indegree.put(c, indegree.get(c)+1);
            }
        }

        return indegree;
    }

    private String topologicalSorting(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = getIndegree(graph);
        Deque<Character> que = new ArrayDeque<>();

        for (char key: indegree.keySet()) {
            if (indegree.get(key) == 0) que.offer(key);
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);
            for(char neighbor: graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0) que.offer(neighbor);
            }
        }

        return sb.length() == indegree.size()? sb.toString(): "";
    }

    
}