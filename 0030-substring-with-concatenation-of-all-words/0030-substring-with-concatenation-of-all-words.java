class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return res;

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> window = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (map.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0)+1);
                    if (window.get(word).equals(map.get(word))) count++;
                    
                    while (window.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        if (window.get(leftWord).equals(map.get(leftWord))) count--;
                        window.put(leftWord, window.get(leftWord)-1);
                        left += wordLen;
                    }

                    if (count == map.size()) res.add(left);
                } else {
                    count = 0;
                    window.clear();
                    left = right;
                }
            }
        }
        return res;
    }
}