class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner case: endword not in wordlist, return 0
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // bfs
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 1;

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                
                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (old == k) continue;
                        chars[j] = k;
                        String newStr = new String(chars);
                        if (newStr.equals(endWord)) return count+1;
                        if (wordSet.contains(newStr) && visited.add(newStr)) {
                            queue.offer(newStr);
                        }
                    }
                    chars[j] = old;
                }
            }
            count++;
        } 
        return 0;
    }
}