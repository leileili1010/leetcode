class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        if (!wordListSet.contains(endWord)) return 0;

        Deque<String> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.offer(beginWord);
        visited.add(beginWord);
        int count = 1;

        while (!que.isEmpty()) {
            int n = que.size();
            count++;
            for (int i = 0; i < n; i++) {
                String cur = que.poll();
                for (String nextWord: getNextWords(cur, wordListSet)) {
                    if (nextWord.equals(endWord)) return count;
                    if (visited.add(nextWord)) que.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(String cur, Set<String> wordListSet) {
        List<String> res = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == c) {
                    continue;
                }
                String newWord = replace(cur, i, c);
                if (wordListSet.contains(newWord)) {
                    res.add(newWord);
                }
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