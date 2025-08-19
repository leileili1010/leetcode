class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < strs[0].length(); i++) {
            for (String str: strs) {
                if (i == str.length() || str.charAt(i) != strs[0].charAt(i)) return sb.toString();
            }
                sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}