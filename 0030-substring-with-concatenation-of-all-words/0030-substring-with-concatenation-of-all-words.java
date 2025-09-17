class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); // <word, count>;
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return res;

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right+wordLen);
                right += wordLen;

                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    count++;

                    while (seen.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        
                        seen.put(leftWord , seen.get(leftWord)-1);
                        if (seen.get(leftWord ) == 0) seen.remove(leftWord);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) res.add(left);
                }else{
                    count = 0;
                    seen.clear();
                    left = right;
                }
            }
        }
        return res;
    }
}