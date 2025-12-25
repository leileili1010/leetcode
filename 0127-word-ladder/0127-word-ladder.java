class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // min -> level order BFS
            // iterate every word in a level
                // iterate every letter in a word
                    // change a letter from a to z, put it in queue if 1) in wordlist 2) not visited
        
        // corner case
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        // initialization
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visisted = new HashSet<>();
        queue.offer(beginWord);
        visisted.add(beginWord);

        // BFS
        int steps = 1; // per requirement
        while (!queue.isEmpty()) {
            int n = queue.size();

            // enter a level order traversal
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) return steps+1;
                        if (dict.contains(newWord) && visisted.add(newWord)) {
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