class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert to HashSet for O(1) lookup
        HashSet<String> wordSet = new HashSet<>(wordList);
        
        // If endWord is not in wordList, no transformation possible
        if (!wordSet.contains(endWord)) return 0;
        
        Deque<String> que = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        int res = 1;

        que.offer(beginWord);
        visited.add(beginWord);

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                String cur = que.poll();

                for (String nextWord : getNextWords(cur, wordSet)) {
                    if (visited.contains(nextWord)) continue;
                    if (nextWord.equals(endWord)) return res + 1; // Found path
                    
                    que.offer(nextWord);
                    visited.add(nextWord);
                }
            }
            res++; // Increment after processing current level
        }
        return 0;
    }

    private List<String> getNextWords(String beginWord, HashSet<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < beginWord.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) { // Fixed: c <= 'z'
                if (c == beginWord.charAt(i)) continue;
                String newWord = replace(beginWord, i, c);
                if (wordSet.contains(newWord)) { // Now O(1) lookup
                    nextWords.add(newWord);
                }
            }
        }
        return nextWords;
    }

    private String replace(String beginWord, int i, char c) {
        char[] chars = beginWord.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}