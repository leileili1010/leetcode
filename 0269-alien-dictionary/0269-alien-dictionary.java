class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Step 1: Initialize the graph and indegree map
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check for invalid input
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Add edges based on the first differing character
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2) {
                    if (!graph.get(ch1).contains(ch2)) {
                        graph.get(ch1).add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                    }
                    break;
                }
            }
        }

        // Step 3: Topological Sort using BFS
        Deque<Character> que = new ArrayDeque<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                que.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);
            for (char neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    que.offer(neighbor);
                }
            }
        }

        // Step 4: Check for cycles
        if (sb.length() < indegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
