class Solution {
    private static final char[] CHOICES = {'A', 'C', 'G', 'T'};
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        // corner case
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(endGene)) return -1;

        // initialization
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(endGene);

        // level order BFS
        int steps = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();

            // enter level
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c: CHOICES) {
                        if (c == old) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endGene)) return steps + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            queue.offer(newWord);
                        } 
                    }
                    chars[j] = old;
                }
            }
            // exit level
            steps++;
        }
        return -1;
    }
}