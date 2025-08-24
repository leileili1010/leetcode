class Solution {
    public String alienOrder(String[] words) {
        // construct graph and indegree
        HashMap<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) return "";
        HashMap<Character, Integer> indegree = buildIndegree(graph);
        
        // init starters
        Deque<Character> que = new ArrayDeque<>();
        for (char c: indegree.keySet()) {
            if (indegree.get(c) == 0) que.add(c);
        }

        // bfs
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);

            for (char c: graph.get(cur)) {
                indegree.put(c, indegree.get(c)-1);
                if (indegree.get(c) == 0) que.offer(c);
            }
        }

        return sb.length() == graph.size()? sb.toString(): "";
    }

    private HashMap<Character, Set<Character>> constructGraph(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        
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
            if (word1.length() > word2.length() && word1.startsWith(word2)) return null;

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    graph.get(ch1).add(ch2);
                    break;
                }
            }
        }

        return graph;
    }

    private HashMap<Character, Integer> buildIndegree(HashMap<Character, Set<Character>> graph) {
        HashMap<Character, Integer>indegree = new HashMap<Character, Integer>();

        for (char key: graph.keySet()) {
            indegree.put(key, 0);
        }
        
        for (char key: graph.keySet()) {
            for (char c: graph.get(key)) {
                indegree.put(c, indegree.get(c) + 1);
            }
        }
        return indegree;
    }
}