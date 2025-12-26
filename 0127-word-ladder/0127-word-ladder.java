class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // min/shortest --> level order BFS
        // corner case check: if endWord in wordList, if not return 0
        // BFS 
            // iterate each level
                // iterate each word in the level
                    // iterate each letter
                        // 26

        // corner case 
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        // initialization
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        // BFS
        int steps = 1; // per requirement
        while (!queue.isEmpty()) {
            int n = queue.size();

            // enter the level 
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) return steps + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            queue.offer(newWord);
                        }
                    }
                    chars[j] = old;
                }
            }
            // exit level
            steps++;
        }
        return 0;
    }
}