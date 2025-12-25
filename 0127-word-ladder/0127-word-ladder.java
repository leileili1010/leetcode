class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int steps = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            // Always expand the smaller set (关键优化)
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> next = new HashSet<>();

            for (String word : beginSet) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chars[i] = c;

                        String newWord = new String(chars);

                        // 两边相遇了！答案就是 steps+1
                        if (endSet.contains(newWord)) return steps + 1;

                        // 尚未访问且在字典中
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            next.add(newWord);
                        }
                    }

                    chars[i] = old;
                }
            }

            // Move forward from the side we expanded
            beginSet = next;
            steps++;
        }

        return 0;
    }
}
