class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) return "";
       String word = strs[0];

        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            for (String str: strs) {
                if (i == str.length() || str.charAt(i) != cur) {
                    return word.substring(0, i);
                }
            }
        }
        return word;
    }
}