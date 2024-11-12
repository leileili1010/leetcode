class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        HashMap<String, HashSet<String>> map = new HashMap<>();

       for (List<String> pair: similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            
            map.putIfAbsent(word1, new HashSet<>());
            map.get(word1).add(word2);

            map.putIfAbsent(word2, new HashSet<>());
            map.get(word2).add(word1);
       }

       for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (word1.equals(word2)) {
                continue;
            }

            if (map.get(word1) == null || !map.get(word1).contains(word2)) {
                return false;
            }
       }
        return true;
    }
}