class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int steps = 1; // beginWord itself counts as level 1

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                // ⭐ inline transform — 直接展开，无 helper function，无 List
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        chars[j] = c;
                        String next = new String(chars);

                        if (next.equals(endWord)) return steps + 1;

                        if (dict.contains(next) && visited.add(next)) {
                            queue.offer(next);
                        }
                    }

                    chars[j] = old; // restore
                }
            }

            steps++;
        }

        return 0;
    }
}
