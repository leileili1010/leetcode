class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // corner case 
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // initialization
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        // dfs
        int count = 1;
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

    private List<String> getNextWords(char[] chars, Set<String> set) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                chars[i] = c;
                String newStr = new String(chars);
                if (set.contains(newStr))res.add(newStr);
            }
            chars[i] = old;
        }
        return res;
    }
}