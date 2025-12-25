class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // level order bfs
            // loop each word in a level
                // loop each letter in a word
                    // change the letter from a to z, put it in queue if in wordlist
        
        // corner case 
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // initialization
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(endWord);

        // bfs
        int count = 1; // per requirement
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (String next: getNextWords(chars, wordSet)) {
                    if (next.equals(endWord)) return count+1;
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private List<String> getNextWords(char[] chars, Set<String> wordSet) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newWord = new String(chars);
                if (wordSet.contains(newWord)) res.add(newWord);
            }
            chars[i] = old;
        }
        return res;
    }
}