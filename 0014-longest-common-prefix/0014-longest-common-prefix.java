class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< strs[0].length(); i++) {
            char cur = strs[0].charAt(i);

            for (String str: strs) {
                if (i >= str.length() || str.charAt(i) != cur) return sb.toString();
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}