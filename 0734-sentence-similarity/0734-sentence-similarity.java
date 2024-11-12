class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        // Per constraints, both are non-empty String[], so we dont have to consider edge case null;
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        // value of HashMap could be set
        HashMap<String, HashSet<String>> map = new HashMap<>();

       for (List<String> pair: similarPairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            
            // putifabsent does nothing if key already exists
            map.putIfAbsent(word1, new HashSet<>()); // only initiate hashset if word1 does not exist as key, or do nothing
            map.get(word1).add(word2);

            map.putIfAbsent(word2, new HashSet<>());
            map.get(word2).add(word1);
       }

       for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            // for immutable type, use "=="
            // for object, "==" compares reference and equals() compares content
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