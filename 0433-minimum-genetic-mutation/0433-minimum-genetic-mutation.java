class Solution {
    private static final char[] CHOICES = {'A', 'C', 'G', 'T'};
    
    public int minMutation(String startGene, String endGene, String[] bank) {
        // corner case
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(endGene)) return -1;

        // initialization
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        startSet.add(startGene);
        endSet.add(endGene);
        visited.add(startGene);
        visited.add(endGene);

        // level order BFS
        int steps = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            // optimization
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            // enter level
            for (String word: startSet) {
                char[] chars = word.toCharArray();

                for (int j = 0; j < chars.length; j++) {
                    char old = chars[j];
                    for (char c: CHOICES) {
                        if (c == old) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) return steps + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                           nextSet.add(newWord);
                        } 
                    }
                    chars[j] = old;
                }
            }
            // exit level
            startSet = nextSet;
            steps++;
        }
        return -1;
    }
}