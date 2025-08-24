class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. define data structure
        Deque<String> que = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        int res = 1;

        // 2. add initial value
        que.offer(beginWord);
        visited.add(beginWord);

        while (!que.isEmpty()) {
            int size = que.size();
            res++;

            for (int i = 0; i < size; i++) {
                String cur = que.poll();

                for (String nextWord: getNextWords(cur, wordList)) {
                    if (visited.contains(nextWord)) continue;
                    if (nextWord.equals(endWord)) return res;

                    que.offer(nextWord);
                    visited.add(nextWord);
                } 
            }
        } 
        return 0;
    }

    private List<String> getNextWords(String beginWord, List<String> wordList) {
        List<String> nextWords = new ArrayList<>();
        for (int i = 0; i < beginWord.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == beginWord.charAt(i)) continue;
                String newWord = replace(beginWord, i, c);
                if (wordList.contains(newWord)) {
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