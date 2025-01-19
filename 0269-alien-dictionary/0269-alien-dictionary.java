class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word: words) {
            for (char c: word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (ch1 != ch2 && !graph.get(ch1).contains(ch2)) {
                    graph.get(ch1).add(ch2);
                    indegree.put(ch2, indegree.get(ch2)+1);
                    break;
                }
            }
        }

        Deque<Character> que = new ArrayDeque<>();
        for (char c: indegree.keySet()) {
            if (indegree.get(c) == 0) que.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            char cur = que.poll();
            sb.append(cur);
            for (char c: graph.get(cur)) {
                indegree.put(c, indegree.get(c)-1);
                if (indegree.get(c) == 0) que.offer(c);
            }
        }

         if (sb.length() < indegree.size()) {
            return "";
        }
        
        return sb.toString();
    }
}