class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.offer(beginWord);
        visited.add(beginWord);

        int distance = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            distance++;
            
            for (int i = 0; i < n; i++) {
                String curr = que.poll();

                for (String next: getNextWords(curr, set)) {
                    if (next.equals(endWord)) return distance+1;
                    if (!visited.contains(next)) {
                        que.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(String word, Set<String> set) {
        List<String> res = new ArrayList<>();
        
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) continue;
                char[] letters =  word.toCharArray();
                letters[i] = c;
                String next = new String(letters);
                if (set.contains(next)) res.add(next);
            }
        }
        return res;
    }
}