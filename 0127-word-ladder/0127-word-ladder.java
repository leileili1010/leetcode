class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // corner case
        Set<String> dict = new HashSet<>(wordList); 
        if (!dict.contains(endWord)) return 0;

        // initialization
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);

        // bi-dir BFS
        int steps = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // always search on the smaller Set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            // enter level
            for (String word: beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) return steps + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            nextSet.add(newWord);
                        }
                    }
                    chars[i] = old;
                }
            }
            // finish level
            beginSet = nextSet;
            steps++;
        }
        return 0;
    }
}

// time: O(N * 26* L^2)