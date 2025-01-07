class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsList = new HashSet<>(wordList);
        if (!wordsList.contains(endWord)) return 0; // Early termination if endWord is not in wordList

        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();

        int count = 1; // Start with 1 to include the beginWord itself
        que.offer(beginWord);
        visited.add(beginWord);

        while (!que.isEmpty()) {
            int size = que.size(); // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                for (String nextWord : getNextWords(wordsList, cur)) {
                    if (nextWord.equals(endWord)) {
                        return count + 1; // Include the last transformation
                    }
                    if (visited.add(nextWord)) { // Add only if not visited
                        que.offer(nextWord);
                    }
                }
            }
            count++; // Increment the level after processing the current level
        }
        return 0;
    }

    private List<String> getNextWords(Set<String> wordsList, String word) {
        List<String> res = new ArrayList<>();
        char[] letters = word.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char original = letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (letters[i] == c) continue;
                letters[i] = c;
                String newWord = new String(letters);
                if (wordsList.contains(newWord)) {
                    res.add(newWord);
                }
            }
            letters[i] = original; // Restore the original character
        }
        return res;
    }
}
