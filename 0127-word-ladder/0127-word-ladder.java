class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0; // true

        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.offer(beginWord); // que: hit
        visited.add(beginWord); // visited: hit, hot, dot, lot

        int count = 0; // count = 0
        while (!que.isEmpty()) {
            int n = que.size(); // n = 1
            count++; // count = 2

            for (int i = 0; i < n; i++) { // i = 0
                String curr = que.poll(); // curr = dot, log

                for (String next: getNextWords(curr, set)) { // dot: dot, lot, 
                    if (next.equals(endWord)) return count+1; // 
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
                if (word.charAt(i) == c) continue;
                String next = replace(word, i, c);
                if (set.contains(next)) res.add(next); 
            }
        }
        return res;
    }

    private String replace(String word, int idx, char c) {
        char[] letters = word.toCharArray();
        letters[idx] = c;
        return new String(letters);
    }
}