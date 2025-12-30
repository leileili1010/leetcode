class Solution {
    private static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return List.of();

        List<String> res = new ArrayList<>();
        dfs(digits, res, new StringBuilder(), 0);
        return res;
    }
    
    private void dfs(String digits, List<String> res, StringBuilder sb, int k) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        String letters = MAPPING[digits.charAt(k)-'0'];
        for (char c: letters.toCharArray()) {
            sb.append(c);
            dfs(digits, res, sb, k+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}