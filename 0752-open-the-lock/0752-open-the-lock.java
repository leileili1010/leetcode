class Solution {
    public int openLock(String[] deadends, String target) {        
        // edge case
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;

        // bfs
        Deque<String> que = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        que.offer("0000");
        visited.add("0000");

        int steps = 0;
        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                String cur = que.poll();
                if (cur.equals(target)) return steps;

                for (String next: getNextWord(cur)) {
                    if (!visited.contains(next) && !dead.contains(next)) {
                        if (next.equals(target)) return steps + 1;
                        que.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private List<String> getNextWord(String cur) {
        List<String> res = new ArrayList<>();
        char[] chars = cur.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            // + 1
            chars[i] = original == '9' ? '0' : (char)(original + 1);
            res.add(new String(chars));
            
            // -1    
            chars[i] = original == '0' ? '9' : (char)(original - 1);
            res.add(new String(chars));

            chars[i] = original;
        }
        return res;
    }
}