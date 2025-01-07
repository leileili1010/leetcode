class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordsList = new HashSet<>(wordList);
        if (!wordsList.contains(endWord)) return 0;

        Set<String> visited = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        que.offer(beginWord);
        visited.add(beginWord);
        int count = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur = que.poll();
                for (String nextWord: getNextWords(wordsList, cur)) {
                    if (nextWord.equals(endWord)) {
                        return count;
                    }
                    if (visited.add(nextWord)) que.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(Set<String> wordsList, String word) {
        List<String> res = new ArrayList<>();
        char[] letters = word.toCharArray();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < letters.length; i++) {
                if (letters[i] == c) continue;
                String newWord = replace(word, c, i);
                if (wordsList.contains(newWord)) res.add(newWord);
            }
        }
        return res;
    }

    private String replace(String word, char c, int idx) {
        char[] letters = word.toCharArray();
        letters[idx] = c;
        return new String(letters);
    }
}