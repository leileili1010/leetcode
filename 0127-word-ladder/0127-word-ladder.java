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

        // bi-dir bfs
        int steps = 1; // per requirement
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // always loop through teh smaller Set
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextSet = new HashSet<>();

            // level order traversal
            for (String word: beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (endSet.contains(next)) return steps + 1;
                        if (dict.contains(next) && visited.add(next)) {
                            nextSet.add(next);
                        }
                    }
                    chars[i] = old;
                }
            }
            steps++;
            beginSet = nextSet;
        }   
        return 0;
    }
}