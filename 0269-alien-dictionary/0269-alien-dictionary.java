class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) return "";
        return topologicalSorting(graph);
    }

    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word: words) {
            for (char c: word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            // edge case check
            if (word1.length() > word2.length() && word1.startsWith(word2)) return null;
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
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
        PriorityQueue<Character> que = new PriorityQueue<>();

        for (char c: indegree.keySet()) {
            if (indegree.get(c) == 0) que.offer(c);
        } 

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);
            for (char neighbor: graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0) que.offer(neighbor);
            }
        }

        return sb.length() == indegree.size()? sb.toString(): "";
    }
}