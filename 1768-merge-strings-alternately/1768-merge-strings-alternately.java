class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if (word1.length() > i) sb.append(word1.substring(i));
        else if (word2.length() > j) sb.append(word2.substring(j));
        return sb.toString();
    }
}